package com.nasim.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import com.nasim.exception.Response;
import com.nasim.exception.ResponseBuilder;

@Aspect
@Configuration
public class DataValidation {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("@annotation(com.nasim.annotation.Validated) && args(..)")
	public Response validatedData(ProceedingJoinPoint joinPoint) {
		Object[] arguments = joinPoint.getArgs();
		BindingResult result = null;
		for (int i = 0; i < arguments.length; i++) {
			if (arguments[i] instanceof BindingResult) {
				result = (BindingResult) arguments[i];
				break;
			}
		}
		if (result.hasErrors()) {
			return ResponseBuilder.getFailureResponse(result, "Bean Binding error");
		}
		try {
			return (Response) joinPoint.proceed();
		} catch (Throwable e) {
			logger.error(e.getMessage());
			return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
		}

	}
}
