package testdata;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import com.google.gson.Gson;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person person=new Person(1, "mu", "test");
		Gson gson=new Gson();
		String json=gson.toJson(person);
		System.out.println(json);
		JSONObject jo = JSONObject.fromObject(json);
		XMLSerializer xmlSerializer = new XMLSerializer();
		String xml = xmlSerializer.write(jo);
		System.out.println(xml);
		
	}

}
