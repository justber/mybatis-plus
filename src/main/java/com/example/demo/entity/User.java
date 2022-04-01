package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private String email;

    @TableField(fill = FieldFill.INSERT) // 标注该字段为非主键的字段标识，insert表示插入填充字段
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE) // 表示插入并更新该字段
    private Date update_time;

    @Version
    @TableField(value = "version")
    private int version;
}
