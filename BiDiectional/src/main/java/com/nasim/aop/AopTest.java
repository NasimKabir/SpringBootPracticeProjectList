package com.nasim.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("allControllerAndService()")
	public void testLog() {
		logger.info("All test result");
	}

	@Pointcut("(execution(public * com.nasim.controller.*.*(..)) "
			+ "|| execution(public * com.nasim.service.*.*(..))) "
			+ "&& !execution(public * com.nasim.security.UserDetailsServiceImpl.*(..)))")
	public void allControllerAndService() {
	}
}
