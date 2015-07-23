package other;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ErrorHandler implements HandlerExceptionResolver {

	/**
	 * 统一异常处理，需要在配置文件中配置
	 * <bean id="exceptionResolver" class="other.ErrorHandler" />
	 * 异常的处理顺序是
	 * 先Controller中的@ExceptionHandler方法
	 * 再@ControllerAdvice中的@ExceptionHandler方法
	 * 后HandlerExceptionResolver
	 * 哪个处理了后面的就不再处理
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		System.out.println("ErrorHandler");
		return null;
	}

}
