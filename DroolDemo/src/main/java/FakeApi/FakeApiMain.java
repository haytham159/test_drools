package FakeApi;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;

public class FakeApiMain {
	
	private int age;
	
	public int getAge() {
		return age;
	}
    public static void main (String args[]) throws JSONException{
    	Parser parser = new Parser();
        Parser.doHttpGet();
        
        
        
		
      
    	
    }
}