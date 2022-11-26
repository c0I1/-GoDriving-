package com.mana.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName department
 */
@Data
public class Department implements Serializable {
    /**
     * 部门编号
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 描述
     */
    private String description;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}