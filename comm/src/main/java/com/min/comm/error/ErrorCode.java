package com.min.comm.error;

public interface ErrorCode {
    /**
     * 获取结果码
     *
     * @return
     */
    String getCode();

    /**
     * 获取结果码描述信息
     *
     * @return
     */
    String getMessage();
}
