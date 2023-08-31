package com.wjf.demo.commonweb.config;

import com.wjf.demo.commonweb.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalException {

    private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e){
        String message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        logger.error("全局异常捕获：{}", e);
        return ResultVO.error(message);
    }

}
