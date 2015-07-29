package testjsonxml;

import org.springframework.util.xml.DomUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thoughtworks.xstream.XStream;

public class Test {

	public static void main(String[] args) {
		Package p=new Package(1, "流量套餐", "10", "20");
		Gson gson=new Gson();
		String json=gson.toJson(p);
		System.out.println(json);
		JsonObject obj=gson.fromJson(json, JsonObject.class);
		XStream xStream=new XStream();
		String xml= xStream.toXML(obj);
		System.out.println(xml);
	}

}
