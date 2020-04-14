package main.java;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Main class for demonstrating json deserialization from a json file
 * into java objects and serialization to a json file from those objects. 
 * @author Jacob Labrec
 * 
 */
public class Main{
	public static void main(String[] args) {

		//List for storing deserialized objects. 
		LinkedList<Shopper> shoppers= new LinkedList<>();
		
		JSONParser parser = new JSONParser();
		try{
			//Open the file and read in the main json array
			FileReader reader = new FileReader("shoppingLists.json");
			Object obj = parser.parse(reader);
			JSONArray shoppingList = (JSONArray)obj;

			//Iterate over the array elements(jsonobjects) and 
			//create shoppers from them.
			for(int i =0; i < shoppingList.size(); i++) {
				JSONObject object = (JSONObject)shoppingList.get(i);
				//System.out.println(object);
				Shopper shopper = new Shopper(object);
				shoppers.add(shopper);
			}
			
			//Print some of the read in information. 
			for(Shopper shopper : shoppers) {
				System.out.println("Shopper Name: "+shopper.username);
				System.out.println("Products in list: ");
				for(Product product : shopper.list){
					System.out.format("\t%s\n",product.item);
				}
			}

			//System.out.println("\n\n"+shoppers.get(0).toJsonString());
			

			//export to file
			JSONArray outArr = new JSONArray();
			
			for(Shopper shopper: shoppers) {
				outArr.add(shopper.toJsonObject());
			}

			FileWriter file = new FileWriter("shoppingLists.json");
			file.write(outArr.toJSONString());
			file.flush();


		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	

	
}
