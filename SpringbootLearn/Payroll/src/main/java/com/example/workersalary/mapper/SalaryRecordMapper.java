package com.example.workersalary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workersalary.entity.SalaryRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface SalaryRecordMapper extends BaseMapper<SalaryRecord> {

    @Select("SELECT sr.*, w.name as worker_name, w.phone, w.id_card, w.bank_card, w.bank_brand " +
            "FROM salary_records sr " +
            "LEFT JOIN workers w ON sr.worker_id = w.id " +
            "WHERE sr.salary_date = #{salaryDate}")
    List<SalaryRecord> selectWithWorkerInfo(String salaryDate);
}