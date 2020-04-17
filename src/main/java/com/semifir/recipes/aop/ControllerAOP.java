package com.semifir.recipes.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAOP {

	private Logger logger = LoggerFactory.getLogger(ControllerAOP.class);
	
	@Before("@annotation(com.semifir.recipes.annotations.RequestToLog)")
	public void logController(JoinPoint jp) {
		logger.info("liefglkgfmo");
	}
	
	@Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void logGet() {
		logger.info("GET Request");
	}
}
