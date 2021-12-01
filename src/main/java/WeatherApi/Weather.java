package WeatherApi;

import org.apache.http.HttpEntity;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Weather {
    public static void doHttpGet(){
        
    	String ApiKey = "yOl8fg34Q6YViulWYBr9GIW5zqXnSPbr";
        String url = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/348735?apikey=" + ApiKey;
        

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = null;
        try {
            resp = client.execute(get);
            HttpEntity entity = resp.getEntity();
            System.out.println("Json response");
            System.out.println(EntityUtils.toString(entity));
            

        }
        catch (IOException ioe) { System.err.println("Something went wrong getting the weather: ");  ioe.printStackTrace(); }
        catch (Exception e ){ System.err.println("Unknown error: "); e.printStackTrace(); }
    }
}