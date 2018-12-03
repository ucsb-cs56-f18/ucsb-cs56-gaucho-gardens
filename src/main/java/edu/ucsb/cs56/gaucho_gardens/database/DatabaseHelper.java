package edu.ucsb.cs56.gaucho_gardens.database;

import java.util.ArrayList;
import edu.ucsb.cs56.gaucho_gardens.webapp.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseHelper {

	private ArrayList<Vegetable> checkedVeg = new ArrayList<Vegetable>();
	@Autowired
	private Database db;
	
	public ArrayList<Vegetable> getPlants(String season, int length){
		ArrayList<Vegetable> veg = new ArrayList<Vegetable>();
        for(Vegetable v: db.findAll()){
            if(v.getSeason().equals(season) && !checkedVeg.contains(veg)){ 
                veg.add(v);
                checkedVeg.add(v);
                if(veg.size() == length)
                    return veg;
            }
        }
        return veg;
	}

}
