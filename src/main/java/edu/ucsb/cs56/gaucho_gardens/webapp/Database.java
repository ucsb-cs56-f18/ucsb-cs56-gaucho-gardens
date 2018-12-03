package edu.ucsb.cs56.gaucho_gardens.database;

import edu.ucsb.cs56.gaucho_gardens.webapp.Vegetable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface Database extends MongoRepository<Vegetable, String>{
    public Vegetable findByName(String name);
}