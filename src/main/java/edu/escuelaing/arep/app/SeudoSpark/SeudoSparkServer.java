package edu.escuelaing.arep.app.SeudoSpark;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import edu.escuelaing.arep.app.HttpServer;
import edu.escuelaing.arep.app.Processor;

public class SeudoSparkServer implements Processor {
    private int httpPort;
    private static SeudoSparkServer instance = new SeudoSparkServer();
    Map<String, BiFunction<HttpRequest, HttpResponse, String>> functions = new HashMap(); 
    HttpServer server = new HttpServer();
    
    /**
     * Constructor of the SeudoSparkServer
     */
    private SeudoSparkServer() {
        server.registerProcessor("/",this);
    }



    /**
     * The method that implements the singleton in this class
     * @return SeudoSparkServer, return the instance of this class
     */
    public static SeudoSparkServer getInstance() {
        return instance;
    }


    /**
     * This is a GET method that response the request 
     * @param route route that request the client
     * @param sup response for this request
     */
    public void get(String route, BiFunction<HttpRequest, HttpResponse, String> sup) {
        functions.put(route, sup);
    }
    
    /** 
     * This method start the server
     */
    public void startServer() {
        try {
            server.startServer(httpPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This methos set the port of the server
     * @param serverPort server port
     */
    public void port(int serverPort) {
        this.httpPort = serverPort;
    }

    /**
     * This method handle the http requests
     * @param path path that request the client
     * @param req request of this path
     * @param resp response of this request
     */
    public String handle(String path, HttpRequest req, HttpResponse resp) {
        if (functions.containsKey(path)) {
            return httpHeader() + functions.get(path).apply(req , resp);
        }
        return httpError();
    }

    /**
     * This method get the template of http error
     * @return String
     */
    private String httpError() {
        return "HTTP/1.1 200 OK\r\n"
        + "Content-Type: text/html\r\n"
         + "\r\n"
         + "<!DOCTYPE html>\n"
         + "<html>\n"
         + "<head>\n"
         + "<meta charset=\"UTF-8\">\n"
         + "<title>Title of the document</title>\n"
         + "</head>\n"
         + "<body>\n"
         + "<h1>Error</h1>\n"
         + "</body>\n"
         + "</html>\n";
    }

    /**
     * This method return the correct http header
     * @return
     */
    private String httpHeader() {
        return "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n" + "\r\n";
    }
}
