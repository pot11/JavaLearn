package com.example.workersalary.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workersalary.entity.SalaryRecord;
import com.example.workersalary.entity.Worker;
import com.example.workersalary.mapper.SalaryRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SalaryRecordService extends ServiceImpl<SalaryRecordMapper, SalaryRecord> {

    @Autowired
    private WorkerService workerService;

    public List<SalaryRecord> getSalaryRecordsWithWorkerInfo(String salaryDate) {
        return this.baseMapper.selectWithWorkerInfo(salaryDate);
    }

    public boolean generateSalaryRecord(SalaryRecord salaryRecord) {
        // 设置默认时薪
        if (salaryRecord.getHourlyRate() == null) {
            salaryRecord.setHourlyRate(new BigDecimal("50.00"));
        }

        // 自动计算总工资
        if (salaryRecord.getWorkHours() != null && salaryRecord.getHourlyRate() != null) {
            BigDecimal total = salaryRecord.getWorkHours().multiply(salaryRecord.getHourlyRate());
            salaryRecord.setTotalSalary(total);
        }

        // 设置发薪日期
        if (salaryRecord.getSalaryDate() == null) {
            salaryRecord.setSalaryDate(LocalDate.now());
        }

        return this.save(salaryRecord);
    }

    public SalaryRecord createSalaryRecordFromWorker(Long workerId, BigDecimal workHours) {
        Worker worker = workerService.getById(workerId);
        if (worker == null) {
            return null;
        }

        SalaryRecord record = new SalaryRecord();
        record.setWorkerId(workerId);
        record.setWorkHours(workHours);
        record.setHourlyRate(new BigDecimal("50.00"));
        record.setSalaryDate(LocalDate.now());

        // 计算总工资
        BigDecimal total = workHours.multiply(record.getHourlyRate());
        record.setTotalSalary(total);

        return record;
    }
}