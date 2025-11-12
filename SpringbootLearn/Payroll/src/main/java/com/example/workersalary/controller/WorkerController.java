package com.example.workersalary.controller;

import com.example.workersalary.entity.Worker;
import com.example.workersalary.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/worker")
@CrossOrigin(origins = "*") // 允许前端跨域访问
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    // 获取所有工人列表
    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getAllWorkers() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Worker> workers = workerService.getAllWorkersOrderByName();
            result.put("code", 200);
            result.put("message", "success");
            result.put("data", workers);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "获取工人列表失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }

    // 根据ID获取工人信息
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getWorkerById(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            Worker worker = workerService.getById(id);
            if (worker != null) {
                result.put("code", 200);
                result.put("message", "success");
                result.put("data", worker);
                return ResponseEntity.ok(result);
            } else {
                result.put("code", 404);
                result.put("message", "工人不存在");
                return ResponseEntity.status(404).body(result);
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "获取工人信息失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }

    // 添加工人
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addWorker(@RequestBody Worker worker) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean saved = workerService.save(worker);
            if (saved) {
                result.put("code", 200);
                result.put("message", "添加工人成功");
                result.put("data", worker);
                return ResponseEntity.ok(result);
            } else {
                result.put("code", 500);
                result.put("message", "添加工人失败");
                return ResponseEntity.internalServerError().body(result);
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "添加工人失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }

    // 更新工人信息
    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateWorker(@RequestBody Worker worker) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean updated = workerService.updateById(worker);
            if (updated) {
                result.put("code", 200);
                result.put("message", "更新工人信息成功");
                return ResponseEntity.ok(result);
            } else {
                result.put("code", 500);
                result.put("message", "更新工人信息失败");
                return ResponseEntity.internalServerError().body(result);
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "更新工人信息失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }

    // 删除工人
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteWorker(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean removed = workerService.removeById(id);
            if (removed) {
                result.put("code", 200);
                result.put("message", "删除工人成功");
                return ResponseEntity.ok(result);
            } else {
                result.put("code", 500);
                result.put("message", "删除工人失败");
                return ResponseEntity.internalServerError().body(result);
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "删除工人失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }

    // 搜索工人
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchWorkers(@RequestParam String name) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Worker> workers = workerService.getWorkersByName(name);
            result.put("code", 200);
            result.put("message", "success");
            result.put("data", workers);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "搜索工人失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }
}