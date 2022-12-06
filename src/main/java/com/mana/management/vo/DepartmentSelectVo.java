package com.mana.management.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DepartmentSelectVo implements Serializable {

    private static final long serialVersionUID = 8445065663039274650L;
    private Integer id;
    private String departmentName;
}
