package com.mana.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName personal_reward
 */
@Data
public class PersonalReward implements Serializable {
    /**
     *
     */
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
     * 职位名称
     */
    private String positionName;

    /**
     * 日期
     */
    private Date rewardDate;

    /**
     * 奖罚种类 1：奖励 2：惩罚
     */
    private Integer rewardKind;

    /**
     * 金额
     */
    private Long rewardAmount;

    /**
     * 奖罚描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}