package com.example.workersalary.controller;

import com.example.workersalary.entity.SalaryRecord;
import com.example.workersalary.service.SalaryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/salary")
@CrossOrigin(origins = "*")
public class SalaryController {

    @Autowired
    private SalaryRecordService salaryRecordService;

    // 生成工资记录
    @PostMapping("/generate")
    public ResponseEntity<Map<String, Object>> generateSalary(@RequestBody SalaryRecord salaryRecord) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean success = salaryRecordService.generateSalaryRecord(salaryRecord);
            if (success) {
                result.put("code", 200);
                result.put("message", "工资记录生成成功");
                result.put("data", salaryRecord);
                return ResponseEntity.ok(result);
            } else {
                result.put("code", 500);
                result.put("message", "工资记录生成失败");
                return ResponseEntity.internalServerError().body(result);
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "工资记录生成失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }

    // 快速生成工资记录
    @PostMapping("/quick-generate")
    public ResponseEntity<Map<String, Object>> quickGenerateSalary(
            @RequestParam Long workerId,
            @RequestParam BigDecimal workHours) {
        Map<String, Object> result = new HashMap<>();
        try {
            SalaryRecord record = salaryRecordService.createSalaryRecordFromWorker(workerId, workHours);
            if (record != null && salaryRecordService.save(record)) {
                result.put("code", 200);
                result.put("message", "工资记录快速生成成功");
                result.put("data", record);
                return ResponseEntity.ok(result);
            } else {
                result.put("code", 500);
                result.put("message", "工资记录快速生成失败");
                return ResponseEntity.internalServerError().body(result);
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "工资记录快速生成失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }

    // 获取工资记录列表
    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getSalaryRecords(
            @RequestParam(required = false) String salaryDate) {
        Map<String, Object> result = new HashMap<>();
        try {
            String queryDate = salaryDate != null ? salaryDate : LocalDate.now().toString();
            List<SalaryRecord> records = salaryRecordService.getSalaryRecordsWithWorkerInfo(queryDate);

            result.put("code", 200);
            result.put("message", "success");
            result.put("data", records);
            result.put("queryDate", queryDate);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "获取工资记录失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }

    // 获取指定日期的工资统计
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getSalaryStatistics(
            @RequestParam(required = false) String salaryDate) {
        Map<String, Object> result = new HashMap<>();
        try {
            String queryDate = salaryDate != null ? salaryDate : LocalDate.now().toString();
            List<SalaryRecord> records = salaryRecordService.getSalaryRecordsWithWorkerInfo(queryDate);

            // 计算统计信息
            BigDecimal totalSalary = records.stream()
                    .map(SalaryRecord::getTotalSalary)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal totalHours = records.stream()
                    .map(SalaryRecord::getWorkHours)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            Map<String, Object> statistics = new HashMap<>();
            statistics.put("totalWorkers", records.size());
            statistics.put("totalSalary", totalSalary);
            statistics.put("totalHours", totalHours);
            statistics.put("averageSalary", records.isEmpty() ? BigDecimal.ZERO :
                    totalSalary.divide(new BigDecimal(records.size()), 2, BigDecimal.ROUND_HALF_UP));

            result.put("code", 200);
            result.put("message", "success");
            result.put("data", statistics);
            result.put("records", records);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "获取工资统计失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }

    // 删除工资记录
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteSalaryRecord(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean removed = salaryRecordService.removeById(id);
            if (removed) {
                result.put("code", 200);
                result.put("message", "删除工资记录成功");
                return ResponseEntity.ok(result);
            } else {
                result.put("code", 500);
                result.put("message", "删除工资记录失败");
                return ResponseEntity.internalServerError().body(result);
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "删除工资记录失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }
}