package com.mana.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName personal_salary
 */
@Data
public class PersonalSalary implements Serializable {

    private Integer id;

    /**
     * 员工编号
     */
    private Integer personalId;

    /**
     * 员工姓名
     */
    private String personalName;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 岗位名称
     */
    private String positionName;

    /**
     * 日期
     */
    private Date salaryDate;

    /**
     * 基本工资
     */
    private BigDecimal basisSalary;

    /**
     * 补助工资
     */
    private BigDecimal subsidySalary;

    /**
     * 社保
     */
    private BigDecimal socialSalary;

    /**
     * 公积金
     */
    private BigDecimal providentFund;

    /**
     * 奖金
     */
    private BigDecimal bonus;

    /**
     * 应发工资
     */
    private BigDecimal allSalary;

    private static final long serialVersionUID = 1L;
}