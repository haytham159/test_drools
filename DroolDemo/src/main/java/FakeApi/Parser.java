package FakeApi;

/*import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
*/

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




public class Parser {
	
	private static org.json.JSONArray jsonArray;
	
	public static void setJsonArray(org.json.JSONArray array) {
		jsonArray = array;
	}
	
	public JSONArray getJsonArray() {
		return jsonArray;
	}
	
	
	public static void doHttpGet() {
		
		
		URL url;
		try {
			url = new URL("http://localhost:3000/Clients");
			//call
	        HttpURLConnection con;
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			
			//receive
	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer content = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	            content.append(inputLine);
	        }
	        in.close();
	        String res = content.toString();

	        if (res.startsWith("[")) {
	            //JSON Array
	            JSONArray js = new JSONArray(res);
	            jsonArray = js;
	            for(int i=0; i<jsonArray.length(); i++) {
	                if(jsonArray.get(i) instanceof JSONObject){
	                    JSONObject jsnObj = (JSONObject)jsonArray.get(i);
	                    int finalValue = (int)jsnObj.get("id");
	                    System.out.println(finalValue);
	                }
	            }
	            System.out.println(jsonArray);
	        }

		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*
		 * String url = "http://localhost:3000/Clients";
		 * 
		 * CloseableHttpClient client = HttpClients.createDefault(); HttpGet get = new
		 * HttpGet(url); CloseableHttpResponse resp = null; try { resp =
		 * client.execute(get); HttpEntity entity = resp.getEntity();
		 * System.out.println("Json response"); JSonResponse =
		 * EntityUtils.toString(entity); System.out.println(JSonResponse);
		 * 
		 * 
		 * Object obj = new JSONParser().parse(new
		 * FileReader("C:\\Users\\ASUS\\db.json"));
		 * 
		 * 
		 * 
		 * // typecasting obj to JSONObject JSONObject jo = (JSONObject) obj;
		 * 
		 * JSONArray ja = (JSONArray) jo.get("Clients"); setJsonArray(ja);
		 * System.out.println("printing ja"); System.out.println(jsonArray);
		 * 
		 * Iterator itr1 = ja.iterator(); Iterator itr2 = ja.iterator();
		 * 
		 * while (itr2.hasNext()) { itr1 = ((Map) itr2.next()).entrySet().iterator();
		 * while (itr1.hasNext()) { Map.Entry pair = (Entry) itr1.next();
		 * System.out.println("hola"); System.out.println(pair.getKey() + " : " +
		 * pair.getValue()); } }
		 * 
		 * 
		 * } catch (IOException ioe) {
		 * System.err.println("Something went wrong getting the api infos: ");
		 * ioe.printStackTrace(); } catch (Exception e ){
		 * System.err.println("Unknown error: "); e.printStackTrace(); }
		 */
        

		
	
}
