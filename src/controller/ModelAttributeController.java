package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.Student;

@Controller
public class ModelAttributeController {

	/**
	 * 任何@RequestMapping方法 执行前都 会先调用 这个方法
	 * 有个implicitModel对象把map中的键值对存放进去
	 * 如果有pojo参数的方法被调用，参数没有指明@ModelAttribute参数值，
	 * 则使用类的第一个字母小写为属性名在implicitModel中找值，如果值不存在
	 * 则判断是否有sessionattributes注解，如果有，则判断是否有对应的属性名，有的话则取，取出来为null则异常
	 * 如果没有，则反射创建一个新实例，再把表单的值赋值给对应的属性
	 * 
	 * 
	 * @param map
	 */
	@ModelAttribute
	public void getModel(ModelMap map){
		Student student=new Student(1, "mu");
		map.put("obj", student);
	}
	
	/**
	 * 这是以前的
	 * pojo参数的值
	 * 1、先从中implicitModel中找相应的key，存在则取值
	 * 2、不存在注解，则看是否有sessionAttributes注释，没有注解则反射实例化
	 * 3、有注解则判断是否有key，有则取，取出来为null则异常
	 * 4、没有key，则反射实例化
	 * 5、再把相应的值存放到implicitModel中，并保存到request中
	 * 
	 * 
	 * @param student
	 * @return
	 */
	@RequestMapping("/getModel")
	public String getModel(Student student){
		System.out.println("getModel");
		System.out.println(student);
		return "index";
	}
	

	
	
}
