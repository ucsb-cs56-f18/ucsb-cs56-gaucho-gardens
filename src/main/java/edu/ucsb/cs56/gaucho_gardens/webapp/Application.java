package edu.ucsb.cs56.gaucho_gardens.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.ucsb.cs56.gaucho_gardens.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	private Database db;
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

    @Override
	public void run(String... args) throws Exception {
		db.save(new Vegetable("cucumber","green","winter","pictures/cucumber.jpg"));
		db.save(new Vegetable("beet","green","winter","pictures/beet.jpg"));
		db.save(new Vegetable("broccoli","green","winter","pictures/broccoli.jpeg"));
		for(Vegetable v: db.findAll()){
			System.out.println(v.toString());
		}
	
}
}
