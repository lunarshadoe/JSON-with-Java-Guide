package main.java;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Product {

    public String item,description,category,unitMeasure;
    public long numUnits,quantity;
    public boolean checkbox; 

    public Product(JSONObject obj){
        item = (String)obj.get("item");
        description = (String)obj.get("description");
        category = (String)obj.get("category");
        numUnits=(long)obj.get("number of units");
        quantity=(long)obj.get("quantity");
        checkbox = (Boolean)obj.get("checkbox");
        unitMeasure=(String)obj.get("Units of measurement");

    }

}