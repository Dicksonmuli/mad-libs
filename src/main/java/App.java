import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
		String layout = "templates/layout.vtl";//layout
//get() indicates the area of application to be accessed via HTTP GET request
	 get("/", //index page
	 (request, response) -> {
		 Map<String, Object> model = new HashMap<String, Object>();
		 model.put("template", "templates/form.vtl");//file path
		 return new ModelAndView(model, layout);
	 }, new VelocityTemplateEngine());
//get() indicates the area of application to be accessed via HTTP GET request
	 get("/story", //matching the action on form
	 (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();//defining instance of HashMap
      model.put("template","templates/story.vtl"); //file path
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
