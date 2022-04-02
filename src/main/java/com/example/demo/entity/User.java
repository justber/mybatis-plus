package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
    @TableField(fill = FieldFill.INSERT_UPDATE) // 表示插入并更新该字段
    private Date updateTime;

    @Version
    @TableField(value = "version" ,fill = FieldFill.INSERT)
    private int version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
