import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class App {

	public static void main(String[] args) {
		System.out.format("Started %s\n", new Date());
		toJsonTest();
		fromJsonTest();
		System.out.format("Finished %s\n", new Date());
	}
	
	public static void toJsonTest() {
		HashMap<String, HashSet<String>> myMap = new HashMap<String, HashSet<String>>();
		HashSet<String> mySet = new HashSet<String>();
		mySet.add("Test");
		myMap.put("abcd", mySet);
		Gson gson = new Gson();
		String json = gson.toJson(myMap);
		System.out.println(json);
	}
	
	public static void fromJsonTest() {
		Gson gson = new Gson();
		Type t = new TypeToken<HashMap<String, HashSet<String>>>(){}.getType();
		HashMap<String, HashSet<String>> myMap = gson.fromJson("{\"abcd\":[\"Test\"]}", t);
		System.out.println("We did it");
	}
}
