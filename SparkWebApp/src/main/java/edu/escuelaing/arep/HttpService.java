package edu.escuelaing.arep;

import java.util.*;

public class HttpService extends HttpConnection{
    String stock;
    String time;


    @Override
    public String getURL() {
        return "https://www.alphavantage.co/query?function="+time+"&symbol="+stock+"&interval=5min&apikey=R1CH8N3UDQYTWUEQ";
    }


    @Override
    public void setStock(String input) {
        this.stock=input;    }



    @Override
    public void setTime(String input) {
        this.time = input;




    }

}
