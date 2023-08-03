package com.wjf.demo.commonweb.config;

import com.wjf.demo.commonweb.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e){
        String message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        return ResultVO.error(message);
    }

}
