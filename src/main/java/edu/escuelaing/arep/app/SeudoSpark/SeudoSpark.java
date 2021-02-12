package edu.escuelaing.arep.app.SeudoSpark;

import java.io.File;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.BiFunction;

public class SeudoSpark {
    
    /**
     * 
     * @param route this is the routa that request the client
     * @param body the response of the server
     */
    public static void get(String route, BiFunction<HttpRequest, HttpResponse, String> body){
        SeudoSparkServer server = SeudoSparkServer.getInstance();
        server.get(route, body);
    }

    /**
     * This method set the port of the server
     * @param port port that server runs 
     */
    public static void port(int port){
        SeudoSparkServer server = SeudoSparkServer.getInstance();
        server.port(port);
    }

    /**
     * This method run the http server
     */
    public static void startServer(){
        SeudoSparkServer server = SeudoSparkServer.getInstance();
        server.startServer();
    }

}
