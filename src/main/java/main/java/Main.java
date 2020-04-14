package main.java;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main{
	public static void main(String[] args) {
		System.out.println("This worked\nGreat Job Jake");
		JSONParser parser = new JSONParser();
		try{
			FileReader reader = new FileReader("shoppingLists.json");
			Object obj = parser.parse(reader);
			JSONArray shoppingList = (JSONArray)obj;
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
