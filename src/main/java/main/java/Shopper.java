package main.java;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.LinkedList;
public class Shopper {
    public String username;
    public LinkedList<Product> list; 

    Shopper(JSONObject object) {
        list = new LinkedList<>();
        JSONArray productList = (JSONArray)object.get("shopping list");
        productList.forEach(prod -> list.add(new Product((JSONObject)prod)));
        username = (String)object.get("username");
    }

}