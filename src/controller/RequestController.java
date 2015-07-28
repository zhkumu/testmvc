package controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.Home;

@Controller
public class RequestController {

	
	/**
	 * ant路径匹?为一个字符，*为多个字符，**为多个字符
	 * @return
	 */
	@RequestMapping("/testAnt/?")
	public String testAnt1(){
		System.out.println("testAnt?");
		return "index";
	}
	
	@RequestMapping("/testAnt/*")
	public String testAnt2(){
		System.out.println("testAnt*");
		return "index";
	}
	
	@RequestMapping("/testAnt/**/a")
	public String testAnt3(){
		System.out.println("testAnt**");
		return "index";
	}
	
	/**
	 * 通设置headers头来限制请求时的报头属性值必须匹配，否则匹配不上404错误
	 * @return
	 */
	@RequestMapping(value="/testHeader",headers={"Accept-Language=cn-CN,zh;q=0.8,ja;q=0.6"})
	public String testHeader(){
		System.out.println("testHeader");
		return "index";
	}
	
	/**
	 * 还可以通过请求参数params的值限制是否匹配上，否则匹配不上报400错误
	 * 注意!user为不能有这个参数
	 * @return
	 */
	@RequestMapping(value="/testParams",params={"!user","pwd=123"})
	public String testParams(){
		System.out.println("testParams");
		return "index";
	}
	
	/**
	 * 把路中的某部分当做参数取出来
	 * @param id
	 * @return
	 */
	@RequestMapping("/testPath/{id}")
	public String testPath(@PathVariable("id") Integer id ){
		System.out.println("testPath——"+id);
		return "index";
	}
	
	/**
	 * 指定@RequestParam后默认情况下，该参数必须要传值（required=true），否则报400错误
	 * 如果不想传值则可以指定defaultValue值即可，也可设置required为false
	 * 如果参数是基本类型的想不传值，除以上的处理方法外，还需要把基本类型修改为对应的基本类型的引用类型
	 * 这个注解跟@RequestHeader相类似
	 * @param user
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/testRequestparams")
	public String testRequsetParams(@RequestParam("name") String user,
			@RequestParam(value="pwd",required=true,defaultValue="123456") String pwd){
		System.out.println("testRequestParams"+user+pwd);
		return "index";
	}
	
	/**
	 * 与上面的相类似
	 * @param id
	 * @return
	 */
	@RequestMapping("/testCookie")
	public String testCookie(@CookieValue(value="muid",required=false) String id){
		System.out.println("testCookie——"+id);
		return "index";
	}
	
	/**
	 * 参数对象中的对象字段中的字段传值，参数名为bed.remark即可
	 * @param home
	 * @return
	 */
	@RequestMapping("/testPojo")
	public String testPojo(Home home){
		System.out.println(home);
		return "index";
	}
	
	/**
	 * OutputStream及Write对象是直接从response中取出来的，可以直接传并使用，而不用使用response去取
	 * @param request
	 * @return
	 */
	@RequestMapping("/testServlet")
	public String testServlet(HttpServletRequest request){
		System.out.println(request);
		return "index";
	}
}
