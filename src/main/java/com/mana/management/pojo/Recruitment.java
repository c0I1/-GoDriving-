package com.mana.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


 //@TableName recruitment

@Data
public class Recruitment implements Serializable {

    private Integer id;

    private String departmentName;

    private String positionName;

    private Integer needNum;

    private String demand;

    private String needEducation;

    private Date startDate;

    private Date endTime;
    /**
     * 状态  1:进行中 2：已完成
     *
     *
     */
    private Integer recruitStatus;

    private static final long serialVersionUID = 1L;
}