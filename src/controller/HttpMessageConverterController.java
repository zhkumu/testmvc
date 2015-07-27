package controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Student;

import com.google.gson.Gson;

@Controller
public class HttpMessageConverterController {

	@RequestMapping("/testJson")
	@ResponseBody
	public List<String> testJson(){
		List<String> list=new LinkedList<String>();
		for(int i=0;i<5;i++){
			list.add("num"+i);
		}
		return list;
	}
	
	/**
	 * 返回值是String，所以不是json
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getJsonStr")
	@ResponseBody
	public String getJsonStr(HttpServletResponse response){
		Gson gson=new Gson();
		return gson.toJson("hello world");
	}
	
	/**
	 * json
	 * @param response
	 * @return
	 */
	@RequestMapping("/testJsonObj")
	@ResponseBody
	public Student testJsonObj(HttpServletResponse response){
		Student student=new Student(1, "mu");
		return student;
	}
}
