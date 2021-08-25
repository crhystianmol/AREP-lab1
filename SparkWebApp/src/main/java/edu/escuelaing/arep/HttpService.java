package edu.escuelaing.arep;

import java.util.*;

public class HttpService extends HttpConnection{
    String stock;
    String time;


    @Override
    public String getURL() {
        return "https://www.alphavantage.co/query?function="+time+"&symbol="+stock+"&interval=5min&apikey=R1CH8N3UDQYTWUEQ";
    }

    /**
     * Acciones las cual queremos consultar
     * @param input Accion que consultaremos en este caso (MSFT,IBM)
     */
    @Override
    public void setStock(String input) {
        this.stock=input;    }


    /**
     * Es para ingresar el tiempo que vamos a consultar
     * @param input el tiempo que vamos a consultar en este caso(TIME_SERIES_INTRADAY,TIME_SERIES_DAILY,TIME_SERIES_WEEKLY,TIME_SERIES_MONTHLY)
     */
    @Override
    public void setTime(String input) {
        this.time = input;




    }

}
