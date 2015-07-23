package controller;

import java.rmi.AccessException;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	@RequestMapping("/errorHandler")
	public String errorHandler(int id){
		System.out.println(10/id);
		return "index";
	}
	
	/**
	 * 处理异常，只对这个controller有效
	 * 该方法的参数不能有map类型参数，要向页面传参只能request或返回ModelAndView类型来处理
	 * @param ex
	 * @return
	 */
/*	@ExceptionHandler
	public String HandlerError(Exception ex, HttpServletRequest request){
		//map.put("error", ex);
		request.setAttribute("ex", ex);
		System.out.println(request);
		System.out.println("HandlerException :"+ex.getMessage());
		return "error";
	}*/
	
	@RequestMapping("/testError")
	public String testError(int id){
		return "index";
	}

	/**
	 * ExceptionHandler不指定异常类型，则默认为Exception.class，全局异常处理，但不能同时有默认和指明Exception.class的方法
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public String BaseHandler(Exception ex){
		System.out.println("baseHandler");
		return "error";
	}
	
	/**
	 * 如果匹配的异常类，则执行方法，否则使用全局的
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(AccessException.class)
	public String SubHandler(Exception ex){
		System.out.println("SubHandler");
		return "error";
	}
	
}
