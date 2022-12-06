package com.mana.management.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class PersonalSelectVo implements Serializable {
    private static final long serialVersionUID = 4249534101633399370L;
    private Integer id;
    private String name;
    private Integer departmentId;
    private Integer positionId;
}
