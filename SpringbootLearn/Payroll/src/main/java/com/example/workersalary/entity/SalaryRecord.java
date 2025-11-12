package com.example.workersalary.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("salary_records")
public class SalaryRecord {
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("worker_id")
    private Long workerId;

    // 非数据库字段，用于前端显示
    @TableField(exist = false)
    private String workerName;

    @TableField(exist = false)
    private String phone;

    @TableField(exist = false)
    private String idCard;

    @TableField(exist = false)
    private String bankCard;

    @TableField(exist = false)
    private String bankBrand;

    @TableField("work_hours")
    private BigDecimal workHours;

    @TableField("hourly_rate")
    private BigDecimal hourlyRate;

    @TableField("total_salary")
    private BigDecimal totalSalary;

    @TableField("salary_date")
    private LocalDate salaryDate;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
}