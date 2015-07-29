package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	/**
	 * view解析过程
	 * 先把请求解析为一个ModelAndView对象，通过ViewResolver（视图解析器）获取具体的View类型得到一个View对象
	 * 再处理View中的Model数据，最后渲染View
	 * @return
	 */
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView");
		return "index";
	}
	
	@RequestMapping("/viewController")
	public String viewController(){
		System.out.println("viewController");
		return "index";
	}
	
	/**
	 * 返回的字符串或View名字中有redirect:或forward:将会进行重定向或跳转处理
	 * @return
	 */
	@RequestMapping("/testRdirect")
	public String testRedirect(){
		System.out.println("testRedirect");
		return "redirect:testView";
	}
	
	/**
	 * 这里返回自定义的view的bean名称
	 * @return
	 */
	@RequestMapping("/testMuView")
	public String testMuView(){
		System.out.println("testMuView");
		return "muView";
	}
}
