package other;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstFilter implements HandlerInterceptor {

	/**
	 * 视图解析后执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			Exception exception) throws Exception {
		System.out.println("firstcomplete");
	}

	/**
	 * handler方法执行后执行
	 * handler方法如果有异常就跳过这个方法
	 */
	@Override
	public void postHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			ModelAndView modelandview) throws Exception {
		System.out.println("firstpost");
	}

	/**
	 * handler方法调用前执行
	 * 只有一个拦截器时，该方法返回false将不执行上面两个方法，也不执行handler方法
	 * 当有多个拦截器且该拦截器为第一个并返回false，则后面的拦截器也不会执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj)
			throws Exception {
		System.out.println("firestpre");
		return true;
	}


}
