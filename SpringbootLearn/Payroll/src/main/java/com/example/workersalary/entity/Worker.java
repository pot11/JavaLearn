package com.example.workersalary.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("workers")
public class Worker {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private String phone;

    @TableField("id_card")
    private String idCard;

    @TableField("bank_card")
    private String bankCard;

    @TableField("bank_brand")
    private String bankBrand;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
}