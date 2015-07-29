package other;

import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.View;

/**
 * springmvc自带有多种视图，可直接继承使用
 * @author mu
 *
 */
public class MuView implements View {

	@Override
	public String getContentType() {
		return "text/plain";
	}

	/**
	 * 实现自己页面的返回内容
	 */
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter writer= response.getWriter();
		writer.write("hello world");
		writer.flush();
		writer.close();
	}

}
