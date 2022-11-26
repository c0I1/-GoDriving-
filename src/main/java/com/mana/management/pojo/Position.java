package com.mana.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName position
 */
@Data
public class Position implements Serializable {
    /*
    岗位编号
     */
    private Integer id;
    /*
    岗位名称
     */
    private String positionName;

    /*
    描述
     */
    private String description;

    /*
    部门编号
     */
    private Integer departmentId;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}