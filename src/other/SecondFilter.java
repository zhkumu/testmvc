package other;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecondFilter implements HandlerInterceptor {

	/**
	 * 当有多个拦截器时，且各个方法都返回true，则执行顺序为
	 * firstpre-secondpre-secondpost-firstpost-secondcomplete-firstcomplete
	 * 当有多个拦截器，且该拦截器为非第一个拦截器并返回false，则本身的post和complete方法都不会执行，包括后面的拦截器也不会执行
	 * 并且只执行前面所有拦截器的complete方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj)
			throws Exception {
		System.out.println("secondpre");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			ModelAndView modelandview) throws Exception {
		System.out.println("secondpost");
	}

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			Exception exception) throws Exception {
		System.out.println("secondcomplete");
	}

}
