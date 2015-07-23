package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdivceController {
	
	/**
	 * 统一的异常处理，如果当Controller里没有@ExceptionHandler方法才会执行这个方法
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public String handler(Exception ex,HttpServletRequest request){
		System.out.println("AdivceController");
		return "error";
	}
}
