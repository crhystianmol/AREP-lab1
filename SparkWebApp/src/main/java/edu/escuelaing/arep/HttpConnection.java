package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class HttpConnection {
    private static final String USER_AGENT = "Mozilla/5.0";
    public String TimeSeriesDaily() throws IOException{
        String GET_URL = getURL();
        String responseStr = "Node";
        URL obj = new URL(GET_URL);
        HttpURLConnection con =(HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent",USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("Get Response Code ::"+responseCode);
        if(responseCode== HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String imputLine;
            StringBuffer response = new StringBuffer();
            while ((imputLine = in.readLine()) != null) {
                response.append(imputLine);
            }
            in.close();
            responseStr = response.toString();
            System.out.println(responseStr);
        }else{
            System.out.println("Get request not worked");
        }
        System.out.println("Get Done");
        return responseStr;

    }
    abstract public String getURL();
    abstract public void setStock(String input);
    abstract public void setTime(String input);

}
