package com.szl.springaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect //用@Aspect注解声明切面
public class AspectJLog {
	
	/**
	 * 前置通知
	 * @author Andrew Song
	 */
	@Before("execution(* com.szl.springaop.service.impl.*.*(..))") //声明切入点和通知类型
	public void beforeAdvice(){
		System.out.println("----Hello,this is beforeAdvice,使用注解");
	}

}
