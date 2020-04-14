package main.java;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main{
	public static void main(String[] args) {

		LinkedList<Shopper> shoppers= new LinkedList<>();
		System.out.println("This worked\nGreat Job Jake");
		JSONParser parser = new JSONParser();
		try{
			FileReader reader = new FileReader("shoppingLists.json");
			Object obj = parser.parse(reader);
			JSONArray shoppingList = (JSONArray)obj;
			for(int i =0; i < shoppingList.size(); i++) {
				JSONObject object = (JSONObject)shoppingList.get(i);
				System.out.println(object);
				Shopper shopper = new Shopper(object);
				shoppers.add(shopper);
			}
			

			for(Shopper shopper : shoppers) {
				System.out.println("Shopper Name: "+shopper.username);
				System.out.println("Products in list: ");
				for(Product product : shopper.list){
					System.out.format("\t%s\n",product.item);
				}
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	

	
}
