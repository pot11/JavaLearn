package com.example.workersalary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workersalary.entity.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface WorkerMapper extends BaseMapper<Worker> {

    @Select("SELECT * FROM workers ORDER BY name")
    List<Worker> selectAllOrderByName();

    @Select("SELECT * FROM workers WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Worker> selectByName(String name);
}