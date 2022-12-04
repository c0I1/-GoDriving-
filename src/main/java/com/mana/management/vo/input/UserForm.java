package com.mana.management.vo.input;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class UserForm {

    @NotBlank(message = "用户名必填")
    private String username;

    @NotBlank(message = "密码必填")
    private String password;

    private Integer roleId;
    private String code;
    private String timestamp;
}
