package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.Member;

import service.MuService;

@Controller
public class RestfulController {

	@Autowired
	private MuService muService;
	
	@RequestMapping("/getList")
	public String getList(ModelMap map){
		map.put("list", muService.getList());
		return "list";
	}
	
	@RequestMapping("/add")
	public String add(ModelMap map){
		map.put("member", new Member());
		return "add";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(Member member){
		muService.add(member);
		return "redirect:/getList";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") int id){
		muService.delete(id);
		return "redirect:/getList";
	}
}
