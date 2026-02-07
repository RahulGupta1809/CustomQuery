package com.cglia.customquery.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//Logging Class
@Aspect
@Component
public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.cglia.customquery.service.StudentService.*(..))")
	public void beforeMethodExecution(JoinPoint joinPoint) {
		logger.info("Entering method: {}", joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(* com.cglia.customquery.service.StudentService.*(..))")
	public void afterMethodExecution(JoinPoint joinPoint) {
		logger.info("After method: {}", joinPoint.getSignature().getName());
	}

	@Around("execution(* com.cglia.customquery.service.StudentService.*(..))")
	public Object aroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Before method execution: {}", joinPoint.getSignature());
		Object result = joinPoint.proceed();
		logger.info("After method execution: {}", joinPoint.getSignature());
		return result;
	}
}

