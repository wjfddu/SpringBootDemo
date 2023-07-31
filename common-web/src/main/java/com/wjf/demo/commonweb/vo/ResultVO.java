package com.wjf.demo.commonweb.vo;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 返回数据
 */
@Data
public class ResultVO<T> {

	private Integer code;
	private String message;
	private T data;
	
	public ResultVO() {
		this.code = HttpStatus.OK.value();
		this.message = "success";
	}

	public ResultVO(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResultVO(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static ResultVO error() {
		return new ResultVO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
	}
	
	public static ResultVO error(String message) {
		return new ResultVO(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
	
	public static ResultVO error(Integer code, String message) {
		return new ResultVO(code, message);
	}

	public static ResultVO ok(String message) {
		return new ResultVO(HttpStatus.OK.value(), message);
	}
	
	public static ResultVO ok() {
		return new ResultVO(HttpStatus.OK.value(), "success");
	}

	public static <T> ResultVO<T> data(T data) {
		return new ResultVO(HttpStatus.OK.value(), "success", data);
	}

	public static <T> ResultVO<T> data(String message, T data) {
		return new ResultVO(HttpStatus.OK.value(), message, data);
	}

}
