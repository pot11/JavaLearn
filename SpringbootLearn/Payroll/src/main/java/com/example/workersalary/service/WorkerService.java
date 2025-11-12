package com.example.workersalary.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workersalary.entity.Worker;
import com.example.workersalary.mapper.WorkerMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkerService extends ServiceImpl<WorkerMapper, Worker> {

    public List<Worker> getAllWorkersOrderByName() {
        return this.baseMapper.selectAllOrderByName();
    }

    public List<Worker> getWorkersByName(String name) {
        return this.baseMapper.selectByName(name);
    }
}