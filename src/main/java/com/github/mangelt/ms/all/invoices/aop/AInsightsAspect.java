package com.github.mangelt.ms.all.invoices.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.microsoft.applicationinsights.TelemetryClient;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class AInsightsAspect {
	
	@Autowired
    TelemetryClient telemetryClient;

	@Before("execution(* com.github.mangelt.ms.all.invoices.handler.*.*(..))")
	public void beforeService(JoinPoint joinPoint) {
		log.info("Calling {} method", joinPoint);
		telemetryClient.trackEvent(AInsightsAspect.class.getName() + ": method called " + joinPoint);
	}
	
}
