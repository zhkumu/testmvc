package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import bean.Student;

@Controller
@SessionAttributes(value={"student"})
public class SessionAttributeController {

	/**
	 * 使用sessionattributes后，指定value值或type值后，@RequestMapping中map的属性除了会添加进requset中，还会添加进sessoin域中
	 * @param student
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSession")
	public String testSession(Student student,ModelMap map){
		System.out.println("testSessoin");
		student=new Student(1,"mu");
		map.put("student", student);
		return "session";
	}
	
/*	@ModelAttribute
	public void getModel(ModelMap map){
		map.put("student", new Student(2, "mu"));
	}*/
	
	/**
	 * 3.1以前，如果有session，pojo参数的要从隐藏的model中取，取不到再去session中取（如果有@SessionAttributes）
	 * 如果session没有相应的key，则反射实例化，如果有对应的key则取，取出来null则异常
	 * 
	 * 3.1以后，如果没有显示指定 @ModelAttribute，session中取出为null，不会异常，而是反射实例化 
	 * @param student
	 * @return
	 */
	@RequestMapping("/testSession2")
	public String testSessoin2(@ModelAttribute Student student){
		System.out.println("testSession2");
		System.out.println(student);
		return "session";
	}
}
