package com.wjf.demo.commonweb.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wjf.demo.commonweb.vo.ResultVO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一接口返回数据结构 ResultVO
 *
 */
// 如果引入了swagger或knife4j的文档生成组件，这里需要仅扫描自己项目的包，否则文档无法正常生成
@RestControllerAdvice(basePackages = "com.wjf.demo")
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果不需要进行封装的，可以添加一些校验手段，比如添加标记排除的注解
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        if(body == null){
            return ResultVO.ok();
        }

        // 提供一定的灵活度，如果body已经被包装了，就不进行包装
        if (body instanceof ResultVO) {
            return body;
        }

        // 如果返回值是String类型，那就手动把Result对象转换成JSON字符串
        if (body instanceof String) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.writeValueAsString(ResultVO.data(body));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return ResultVO.data(body);
    }
}