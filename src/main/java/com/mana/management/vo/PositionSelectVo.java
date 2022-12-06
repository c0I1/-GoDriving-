package com.mana.management.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class PositionSelectVo implements Serializable {
    private static final long serialVersionUID = 2002035166649651169L;
    private Integer id;
    private String positionName;
}
