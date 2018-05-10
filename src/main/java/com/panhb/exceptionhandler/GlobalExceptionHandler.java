package com.panhb.exceptionhandler;

import com.panhb.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author panhb
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	@ResponseBody
	public Result exceptionHandler(Exception e) {
		log.error(e.getMessage(),e);
		return Result.err("服务器错误,"+e.getMessage());
	}

}

