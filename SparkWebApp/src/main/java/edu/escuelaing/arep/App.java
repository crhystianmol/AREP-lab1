package edu.escuelaing.arep;



import spark.Request;
import spark.Response;




import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.logging.Level;
import static spark.Spark.*;
/**
 * aplicación para consultar el mercado de valores de las acciones negociadas en Bolsa
 *
 */
public class App 
{
    private static HashMap<String,String> cache = new HashMap();

    /**
     * main del proyecto.
     * @param args Funcionalidad del main.
     */
    public static void main( String[] args )
    {
        port(getport());
        staticFiles.location("Static");
        get("/intraday/:company", (req, res) ->intraDay(req,res)) ;
        get("/daily/:company", (req, res) ->daily(req,res)) ;
        get("/weekly/:company", (req, res) ->weekly(req,res)) ;
        get("/monthly/:company", (req, res) ->monthly(req,res)) ;
    }

    /**
     * nos devuelve el puerto que podemos usar
     * @return El numero de puerto que usaremos
     */


    static int getport() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;


    }

    /**
     * Método que nos da el registro en el día actual
     * @param req requerimiento
     * @param res respuesta
     * @return  un String con un formato tipo .json el cual esta los datos del día
     */
    private static String intraDay(Request req, Response res){
        res.header("Content-Type","application/json");
        String response = "None";
        HttpConnection stockService = CurrentServiceInstance.getInstance().getService();
        if (req.params("company") != null && req.params("company") != ""){
            stockService.setStock(req.params("company"));
            stockService.setTime("TIME_SERIES_INTRADAY");
        }
        if (cache.containsKey(req.params("company")+"TIME_SERIES_INTRADAY")){
            return cache.get(req.params("company")+"TIME_SERIES_INTRADAY");
        }
        try{
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
        }
        cache.put(req.params("company")+"TIME_SERIES_INTRADAY",response);
        return response;
    }
    /**
     * Método que nos da el registro en el día
     * @param req requerimiento
     * @param res respuesta
     * @return  un String con un formato tipo .json el cual esta los datos del día
     */
    private static Object daily(Request req, Response res) {
        res.header("Content-Type","application/json");
        String response = "None";
        HttpConnection stockService = CurrentServiceInstance.getInstance().getService();
        if (req.params("company") != null && req.params("company") != ""){
            stockService.setStock(req.params("company"));
            stockService.setTime("TIME_SERIES_DAILY");
        }
        if (cache.containsKey(req.params("company")+"TIME_SERIES_DAILY")){
            return cache.get(req.params("company")+"TIME_SERIES_DAILY");
        }
        try{
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
        }
        cache.put(req.params("company")+"TIME_SERIES_DAILY",response);
        return response;
    }
    /**
     * Método que nos da el registro en la semana
     * @param req requerimiento
     * @param res respuesta
     * @return  un String con un formato tipo .json el cual esta los datos de la semana
     */
    private static Object weekly(Request req, Response res) {
        res.header("Content-Type","application/json");
        String response = "None";
        HttpConnection stockService = CurrentServiceInstance.getInstance().getService();
        if (req.params("company") != null && req.params("company") != ""){
            stockService.setStock(req.params("company"));
            stockService.setTime("TIME_SERIES_WEEKLY");
        }
        if (cache.containsKey(req.params("company")+"TIME_SERIES_WEEKLY")){
            return cache.get(req.params("company")+"TIME_SERIES_WEEKLY");
        }
        try{
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
        }
        cache.put(req.params("company")+"TIME_SERIES_WEEKLY",response);
        return response;
    }
    /**
     * Método que nos da el registro en el mes
     * @param req requerimiento
     * @param res respuesta
     * @return  un String con un formato tipo .json el cual esta los datos del mes
     */
    private static Object monthly(Request req, Response res) {
        res.header("Content-Type","application/json");
        String response = "None";
        HttpConnection stockService = CurrentServiceInstance.getInstance().getService();
        if (req.params("company") != null && req.params("company") != ""){
            stockService.setStock(req.params("company"));
            stockService.setTime("TIME_SERIES_MONTHLY");
        }
        if (cache.containsKey(req.params("company")+"TIME_SERIES_MONTHLY")){
            return cache.get(req.params("company")+"TIME_SERIES_MONTHLY");
        }
        try{
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
        }
        cache.put(req.params("company")+"TIME_SERIES_MONTHLY",response);
        return response;
    }

}
