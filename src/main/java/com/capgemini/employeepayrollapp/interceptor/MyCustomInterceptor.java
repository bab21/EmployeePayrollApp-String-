package com.capgemini.employeepayrollapp.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
@Component
public class MyCustomInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception{
		System.out.println("Inside pre handle");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,  HttpServletResponse response,Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("Post Handle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler, Exception ex) {
		System.out.println("After Completion");
	}
	
}
