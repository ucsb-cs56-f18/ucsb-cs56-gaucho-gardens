package edu.ucsb.cs56.gaucho_gardens.webapp;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import edu.ucsb.cs56.gaucho_gardens.database.DatabaseHelper;

@Controller
public class HelloController {

    private Vegetable vegetable;	
    private DatabaseHelper db;

    @RequestMapping("/")
    public String index(Model model) {
        vegetable= new Vegetable ("Carrot","orange","winter","pictures/cucumber.jpg");
        model.addAttribute("veg", this.vegetable);
        return "index";
    }

//String = load html file as is
//ModelAndView = we have template and data, stuff data into template
	@RequestMapping("/seasonalplants")
    public ModelAndView page1() {
	  db = new DatabaseHelper();
      //db call here to a regular arraylist obj
      ArrayList<Vegetable> plants = db.getPlants("winter", 3);
      
      Map<String, Object> params = new HashMap<>();
      params.put("plants", plants);

      //this params thing -> ftl. Put any name to the hashmap and value = any java obj (thats a javabean)
      return  new ModelAndView ("seasonalplants", params);
    }

	@RequestMapping("/user_bookmarks")
	public String page2() {
        return "user_bookmarks";
    }
	@RequestMapping("/search")
	public String page3() {
        return "search";
    }
	@RequestMapping("/photos")
    public String page4() {
        return "photos";
    }
	@RequestMapping("/weather")
	public String page5() {
        return "weather";
    }
	@RequestMapping("/cucumber")
	public String page6() {
        return "cucumber";
    }
	@RequestMapping("/cucumberrecipe")
	public String page7() {
        return "cucumberrecipe";
    }
	@RequestMapping("/beet")
	public String page8() {
        return "beet";
    }
	@RequestMapping("/beetrecipe")
	public String page9() {
        return "beetrecipe";
    }
	@RequestMapping("/broccoli")
	public String page10() {
        return "broccoli";
    }
	@RequestMapping("/broccolirecipe")
	public String page11() {
        return "broccolirecipe";
    }

}
