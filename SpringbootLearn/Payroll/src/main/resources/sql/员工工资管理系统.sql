-- worker_management.sql
-- 工人工资管理系统数据库初始化脚本

-- 创建数据库
CREATE DATABASE IF NOT EXISTS `worker_management`
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE `worker_management`;

-- 设置时区
SET time_zone = '+08:00';

-- 工人信息表
CREATE TABLE IF NOT EXISTS `workers` (
                                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name` varchar(100) NOT NULL COMMENT '姓名',
    `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
    `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号',
    `bank_card` varchar(30) DEFAULT NULL COMMENT '银行卡号',
    `bank_brand` varchar(50) DEFAULT NULL COMMENT '银行品牌',
    `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标记(0-未删除,1-已删除)',
    PRIMARY KEY (`id`),
    KEY `idx_name` (`name`),
    KEY `idx_phone` (`phone`),
    KEY `idx_created_time` (`created_time`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='工人信息表';

-- 工资记录表
CREATE TABLE IF NOT EXISTS `salary_records` (
                                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `worker_id` bigint(20) NOT NULL COMMENT '工人ID',
    `work_hours` decimal(10,2) NOT NULL COMMENT '工时',
    `hourly_rate` decimal(10,2) DEFAULT '50.00' COMMENT '时薪',
    `total_salary` decimal(10,2) NOT NULL COMMENT '总工资',
    `salary_date` date NOT NULL COMMENT '发薪日期',
    `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标记(0-未删除,1-已删除)',
    PRIMARY KEY (`id`),
    KEY `idx_worker_id` (`worker_id`),
    KEY `idx_salary_date` (`salary_date`),
    KEY `idx_created_time` (`created_time`),
    CONSTRAINT `fk_salary_worker` FOREIGN KEY (`worker_id`) REFERENCES `workers` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='工资记录表';

-- 插入测试数据 - 工人信息
INSERT INTO `workers` (`name`, `phone`, `id_card`, `bank_card`, `bank_brand`) VALUES
                                                                                  ('张三', '13800138000', '110101199001011234', '6222021234567890123', '工商银行'),
                                                                                  ('李四', '13900139000', '110101199002022345', '6228481234567890124', '农业银行'),
                                                                                  ('王五', '13700137000', '110101199003033456', '6227001234567890125', '建设银行'),
                                                                                  ('赵六', '13600136000', '110101199004044567', '6222621234567890126', '交通银行'),
                                                                                  ('钱七', '13500135000', '110101199005055678', '6225881234567890127', '招商银行'),
                                                                                  ('孙八', '13400134000', '110101199006066789', '6226091234567890128', '邮政储蓄'),
                                                                                  ('周九', '13300133000', '110101199007077890', '6222081234567890129', '工商银行'),
                                                                                  ('吴十', '13200132000', '110101199008088901', '6228461234567890130', '农业银行');

-- 插入测试数据 - 工资记录 (2024年1月)
INSERT INTO `salary_records` (`worker_id`, `work_hours`, `hourly_rate`, `total_salary`, `salary_date`) VALUES
                                                                                                           (1, 176.5, 50.00, 8825.00, '2024-01-15'),
                                                                                                           (2, 160.0, 50.00, 8000.00, '2024-01-15'),
                                                                                                           (3, 182.5, 50.00, 9125.00, '2024-01-15'),
                                                                                                           (4, 168.0, 50.00, 8400.00, '2024-01-15'),
                                                                                                           (5, 172.0, 50.00, 8600.00, '2024-01-15'),
                                                                                                           (6, 156.5, 50.00, 7825.00, '2024-01-15'),
                                                                                                           (7, 164.0, 50.00, 8200.00, '2024-01-15'),
                                                                                                           (8, 176.0, 50.00, 8800.00, '2024-01-15');

-- 插入测试数据 - 工资记录 (2024年2月)
INSERT INTO `salary_records` (`worker_id`, `work_hours`, `hourly_rate`, `total_salary`, `salary_date`) VALUES
                                                                                                           (1, 168.0, 50.00, 8400.00, '2024-02-15'),
                                                                                                           (2, 172.5, 50.00, 8625.00, '2024-02-15'),
                                                                                                           (3, 160.0, 50.00, 8000.00, '2024-02-15'),
                                                                                                           (4, 184.0, 50.00, 9200.00, '2024-02-15'),
                                                                                                           (5, 156.5, 50.00, 7825.00, '2024-02-15'),
                                                                                                           (6, 168.0, 50.00, 8400.00, '2024-02-15'),
                                                                                                           (7, 176.0, 50.00, 8800.00, '2024-02-15'),
                                                                                                           (8, 164.5, 50.00, 8225.00, '2024-02-15');

-- 创建视图 - 工资记录详情视图
CREATE OR REPLACE VIEW `salary_record_details` AS
SELECT
    sr.id,
    sr.worker_id,
    w.name AS worker_name,
    w.phone,
    w.id_card,
    w.bank_card,
    w.bank_brand,
    sr.work_hours,
    sr.hourly_rate,
    sr.total_salary,
    sr.salary_date,
    sr.created_time,
    sr.updated_time
FROM
    salary_records sr
        LEFT JOIN workers w ON sr.worker_id = w.id
WHERE
    sr.deleted = 0 AND w.deleted = 0;

-- 创建存储过程 - 生成月度工资报表
DELIMITER //
CREATE PROCEDURE `GenerateMonthlySalaryReport`(IN report_month VARCHAR(7))
BEGIN
SELECT
    w.name AS worker_name,
    w.phone,
    w.bank_card,
    w.bank_brand,
    sr.work_hours,
    sr.hourly_rate,
    sr.total_salary,
    sr.salary_date
FROM
    salary_records sr
        JOIN workers w ON sr.worker_id = w.id
WHERE
    DATE_FORMAT(sr.salary_date, '%Y-%m') = report_month
  AND sr.deleted = 0
  AND w.deleted = 0
ORDER BY
    w.name;
END //
DELIMITER ;

-- 创建索引优化查询性能
CREATE INDEX idx_workers_deleted ON workers(deleted);
CREATE INDEX idx_salary_records_deleted ON salary_records(deleted);
CREATE INDEX idx_salary_date_month ON salary_records(salary_date);