package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	/**
	 * 上传文件 需要配置
	 * 
	 * <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<property name="maxUploadSize" value="102400" />
		<property name="defaultEncoding" value="utf-8"></property>
	   </bean>
	   其中各种属性视情况而定
	 * @return
	 */
	
	@RequestMapping("/upload1")
	public String upload1(){
		return "upload1";
	}
	
	/**
	 * 上传文件，注意要使用MultipartFile类型，表单的文件标签的name属性值要与@RequestParam一致
	 * @param file
	 * @param dec
	 * @return
	 */
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file,@RequestParam("dec") String dec){
		System.out.println(file.getOriginalFilename()+":"+file.getSize());
		System.out.println(dec);
		return "index";
	}
	
	@RequestMapping("/uploadn")
	public String uploadn(){
		return "uploadn";
	}
	
	/**
	 * 上传多个文件，注意参数类型是 MultipartFile[]，表单多个文件标签的name属性值要与@RequestParam一致
	 * @param files
	 * @param dec
	 * @return
	 */
	@RequestMapping("/uploads")
	public String uploads(@RequestParam("files") MultipartFile[] files,@RequestParam("dec") String dec){
		System.out.println(files.length);
		for (MultipartFile f : files) {
			System.out.println(f.getOriginalFilename());
		}
		System.out.println(dec);
		return "index";
	}
}
