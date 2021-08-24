package edu.escuelaing.arep;



import spark.Request;
import spark.Response;



import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {

        port(getport());
        staticFiles.location("Static");
        get("/intraday/:company", (req, res) ->intraDay(req,res)) ;
        get("/daily/:company", (req, res) ->daily(req,res)) ;
        get("/weekly/:company", (req, res) ->weekly(req,res)) ;
        get("/monthly/:company", (req, res) ->monthly(req,res)) ;
    }




    static int getport() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;


    }
    private static String intraDay(Request req, Response res){
        res.header("Content-Type","application/json");
        String response = "None";
        HttpConnection stockService = CurrentServiceInstance.getInstance().getService();
        if (req.params("company") != null && req.params("company") != ""){
            stockService.setStock(req.params("company"));
            stockService.setTime("TIME_SERIES_INTRADAY");
        }
        try{
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
        }
        return response;
    }
    private static Object daily(Request req, Response res) {
        res.header("Content-Type","application/json");
        String response = "None";
        HttpConnection stockService = CurrentServiceInstance.getInstance().getService();
        if (req.params("company") != null && req.params("company") != ""){
            stockService.setStock(req.params("company"));
            stockService.setTime("TIME_SERIES_DAILY");
        }
        try{
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
        }
        return response;
    }
    private static Object weekly(Request req, Response res) {
        res.header("Content-Type","application/json");
        String response = "None";
        HttpConnection stockService = CurrentServiceInstance.getInstance().getService();
        if (req.params("company") != null && req.params("company") != ""){
            stockService.setStock(req.params("company"));
            stockService.setTime("TIME_SERIES_WEEKLY");
        }
        try{
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
        }
        return response;
    }
    private static Object monthly(Request req, Response res) {
        res.header("Content-Type","application/json");
        String response = "None";
        HttpConnection stockService = CurrentServiceInstance.getInstance().getService();
        if (req.params("company") != null && req.params("company") != ""){
            stockService.setStock(req.params("company"));
            stockService.setTime("TIME_SERIES_MONTHLY");
        }
        try{
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
        }
        return response;
    }

}
