package com.mana.management.exception;


import com.mana.management.enums.ResultEnum;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -4088898423313593435L;
    private String msg;
    private ResultEnum resultEnum;

    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.resultEnum = resultEnum;
    }
}