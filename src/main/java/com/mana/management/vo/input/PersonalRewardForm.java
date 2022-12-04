package com.mana.management.vo.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PersonalRewardForm {
    @NotNull(message = "用户必填")
    private Integer personalId;
    @NotNull(message = "时间必填")
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date rewardDate;
    @NotNull(message = "奖惩类型必填")
    private Integer rewardKind;
    private Long rewardAmount;
    private String description;
}
