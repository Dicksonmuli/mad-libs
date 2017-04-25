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
    //  adding session
    model.put("person1", request.queryParams("person1"));
 model.put("person2", request.session().attribute("person2"));
 model.put("animal", request.session().attribute("animal"));
 model.put("exclamation", request.session().attribute("exclamation"));
 model.put("verb", request.session().attribute("verb"));
 model.put("noun", request.session().attribute("noun"));

		 model.put("template", "templates/form.vtl");//file path
		 return new ModelAndView(model, layout);
	 }, new VelocityTemplateEngine());
//get() indicates the area of application to be accessed via HTTP GET request
	 get("/story", //matching the action on form
	 (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();//defining instance of HashMap
			//retrieving form data
			model.put("person1", request.queryParams("person1"));
	 model.put("person2", request.queryParams("person2"));
	 model.put("animal", request.queryParams("animal"));
	 model.put("exclamation", request.queryParams("exclamation"));
	 model.put("verb", request.queryParams("verb"));
	 model.put("noun", request.queryParams("noun"));
      model.put("template","templates/story.vtl"); //file path
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    
  }
}
