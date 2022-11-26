package com.mana.management.pojo;

import lombok.Data;

import java.io.Serializable;

 // @TableName role
@Data
public class Role implements Serializable {

    private Integer id;

    private String name;

    private String description;

    private Integer permissionId;

    private static final long serialVersionUID = 1L;
}