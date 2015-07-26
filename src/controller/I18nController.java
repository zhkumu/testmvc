package controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class I18nController {

	@Autowired
	private MessageSource messageSource;
	
	/**
	 * 如果没有参数locale，则session的中不会带有相关的locale信息，只会使用默认的i18n全局文件
	 * 如果指定了session，只要指定过一次locale，后面即使没有带该locale参数，也会从session中找到上次指定的值
	 * session中的属性名为org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE
	 * @param locale
	 * @param session
	 * @return
	 */
	@RequestMapping("/testZh")
	public String testZh(Locale locale,HttpSession session){
		System.out.println(messageSource.getMessage("name", null, locale));
		System.out.println(session.getAttribute("localeResolver.LOCALE"));
		return "index";
	}
	
	@RequestMapping("/testEn")
	public String testEn(Locale locale){
		System.out.println(messageSource.getMessage("name", null, locale));
		return "index";
	}

}
