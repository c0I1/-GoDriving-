package com.mana.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName personal
 */
@Data
public class Personal implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 1:男 2：女
     */
    private Integer gender;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 联系电话
     */
    private Long phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证号
     */
    private Long identity;

    /**
     * 学历
     */
    private String education;

    /**
     * 毕业学校
     */
    private String school;

    /**
     * 照片url
     */
    private String imgUrl;

    /**
     * 工作状态：1:正式 2:试用 3:实习 4:离职
     */
    private Integer workStatus;

    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 职位id
     */
    private Integer positionId;

    /**
     * 入职时间
     */
    private Date beginDate;


    private Date createTime;


    private Date updateTime;

    private static final long serialVersionUID = 1L;
}