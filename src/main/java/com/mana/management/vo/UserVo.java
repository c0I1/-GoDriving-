package com.mana.management.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = -2493742024666741317L;
    private Integer id;
    private String username;
    private Integer roleId;
    private String roleDescription;
}
