package com.min.comm.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.min.comm.error.ErrorEnum;
import lombok.Data;

@Data
public class ResultVO<T> {
    private String code;
    private String msg;
    private T data;

    @JsonIgnore
    public boolean getSuccess() {
        return this.code.equals(ErrorEnum.SUCCESS.getCode());
    }

    private ResultVO(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResultVO(ErrorEnum errorEnum, T data) {
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMessage();
        this.data = data;
    }

    public static <T> ResultVO<T> Result(ErrorEnum errorEnum, T data) {
        return new ResultVO<>(errorEnum, data);
    }

    public static <T> ResultVO<T> Result(String code, String msg, T data) {
        return new ResultVO<>(code, msg, data);
    }
}
