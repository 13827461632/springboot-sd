package com.min.comm.exception.advice;

import com.min.comm.exception.BizException;
import com.min.comm.response.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ResultVO handleBizException(BizException e) {
        //TODO 记录日志
        System.out.println("记录exception:"+e.getMessage());
        return ResultVO.Result(e.getErrorCode(), e.getMessage(), null);
    }
}