package main.java;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Product class for json demonstration. Object holds information about a product such as the items name, category and more. 
 * @author Jacob Labrec
 */
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

    /**
     * Returns the json string representation of this object
     * @return
     */
    public String toJsonString(){
            
        return this.toJsonObject().toString();
    }

    /**
     * Returns a JSONObject representation of this object. 
     * @return
     */
    public JSONObject toJsonObject(){
        JSONObject obj = new JSONObject();
        obj.put("item",item);
        obj.put("description",description);
        obj.put("category",category);
        obj.put("units of measurement",unitMeasure);
        obj.put("number of units",numUnits);
        obj.put("quantity",quantity);
        obj.put("checkbox",checkbox);
        return obj;
    }


}