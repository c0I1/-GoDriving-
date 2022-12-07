package com.mana.management.vo.input;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class DepartmentForm {

    @NotBlank(message = "部门名称必填")
    private String departmentName;
    private String description;
}
