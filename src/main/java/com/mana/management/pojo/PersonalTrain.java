package com.mana.management.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PersonalTrain implements Serializable {

    private Integer id;

    /**
     * 员工id
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
     * 开始培训日期
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date beginDate;

    /**
     * 结束培训日期
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date endDate;

    /**
     * 培训内容
     */
    private String trainContent;

    /**
     * 培训分数
     */
    private BigDecimal trainScore;

    /**
     * 费用
     */
    private BigDecimal trainCost;

    /**
     * 备注
     */
    private String remake;

    private static final long serialVersionUID = 1L;
}