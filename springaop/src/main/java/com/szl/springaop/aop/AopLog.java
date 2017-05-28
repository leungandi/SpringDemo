package com.szl.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AopLog {
	
	/**
	 * 前置通知
	 * @author Andrew Song
	 */
	public void beforeAdvice(){
		System.out.println("-----Hello,this is beforeAdvice-----");
	}
	
	/**
	 * 前置通知,获取连接点信息
	 * @author Andrew Song
	 */
	public void beforeAdviceJoinPoint(JoinPoint joinPoint){
		System.out.println("-----Hello,this is beforeAdviceJoinPoint-----");
		System.out.println("连接点对象："+joinPoint.getTarget().getClass().getName());
		System.out.println("连接点方法："+joinPoint.getSignature());
		System.out.println("连接点参数："+joinPoint.getArgs().toString());
	}
	/**
	 * 后置通知
	 * @author Andrew Song
	 */
	public void afterAdvice(){
		System.out.println("-----Hello,this is afterAdvice-----");
	}
		
	/**
	 * 后置返回通知
	 * @author Andrew Song
	 */
	public void afterReturningAdvice(){
		System.out.println("-----Hello,this is afterReturningAdvice-----");
	}
	/**
	 * 后置返回通知-获取返回值
	 * @author Andrew Song
	 */
	public void afterReturningAdviceObject(Object objectVal){
		System.out.println("-----Hello,this is afterReturningAdvice-----");
		System.out.println("业务方法的返回值是："+objectVal);
	}
	/**
	 * 后置异常通知
	 * @author Andrew Song
	 */
	public void afterThrowingAdvice(){
		System.out.println("-----Hello,this is afterThrowingAdvice-----");
	}
	/**
	 * 后置异常通知-获取异常信息
	 * @author Andrew Song
	 */
	public void afterThrowingAdviceException(Exception ex){
		System.out.println("-----Hello,this is afterThrowingAdvice-----");
		System.out.println("抛出的异常信息为："+ex.getMessage());
	}
	
	/**
	 * 环绕通知
	 * @author Andrew Song
	 */
	public void aroundAdvice(){
		System.out.println("-----Hello,this is aroundAdvice-----");
	}
	
	/**
	 * 环绕通知
	 * @author Andrew Song
	 * @throws Throwable 
	 */
	public void aroundAdvicePjp(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("-----目标方法之前输出：Hello,this is aroundAdvicePjp-----");
		//获取目标方法的参数
//		Object[] args = pjp.getArgs();
		if(true){
			pjp.proceed();
		}
		System.out.println("-----目标方法之后输出：Hello,END-----");
	}
	
	
	

}
