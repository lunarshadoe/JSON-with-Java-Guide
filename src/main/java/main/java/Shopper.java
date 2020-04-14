package main.java;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.LinkedList;

/**
 * Shopper class for json deserialization/serialization. Contains a shoppers name and their shopping list. 
 * @author Jacob Labrec
 */
public class Shopper {
    public String username;
    public LinkedList<Product> list; 

    /**
     * Constructor takes a  json object and marshalls the data into a shopper
     * instance. 
     * @param object
     */
    Shopper(JSONObject object) {
        list = new LinkedList<>();

        //Get shopping list array and process it 
        JSONArray productList = (JSONArray)object.get("shopping list");
        productList.forEach(prod -> list.add(new Product((JSONObject)prod)));

        
        username = (String)object.get("username");
    }

}