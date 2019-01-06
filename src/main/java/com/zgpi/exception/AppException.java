package com.zgpi.exception;

import com.zgpi.enums.ResultEnum;
import lombok.Getter;

@Getter
public class AppException extends RuntimeException{

    private Integer code;

    public AppException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public AppException(String message) {
        super(message);
        this.code = -1;
    }

    public AppException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
