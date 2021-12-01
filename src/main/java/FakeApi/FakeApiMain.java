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
        
        
        /*
        System.out.println("trying the string first");
        System.out.println(parser.getJSonResponse());
        
        String test = "{ \"test\" : 20 }";
        
        JsonNode node;
		try {
			//node = parser.parse(parser.getJSonResponse());
			node = parser.parse(test);
			System.out.println(node.get("test").asText());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		JSONObject obj = new JSONObject(parser.getJSonResponse());
		
		JSONArray arr = obj.getJSONArray("Clients");
		for (int i = 0; i < arr.length(); i++)
		{
		    String id = arr.getJSONObject(i).getString("name");
		    System.out.println(id);
		}
		*/
		
      
    	
    }
}