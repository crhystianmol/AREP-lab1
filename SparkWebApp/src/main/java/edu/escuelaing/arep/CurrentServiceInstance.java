package edu.escuelaing.arep;

public class CurrentServiceInstance {
    private static CurrentServiceInstance _instance =new CurrentServiceInstance();
    private HttpService service;
    private CurrentServiceInstance(){
        service =new HttpService();
    }
    public static CurrentServiceInstance getInstance(){
        return _instance;
    }
    public HttpService getService(){
        return service;
    }

}
