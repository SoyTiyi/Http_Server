package edu.escuelaing.arep.app.SeudoSpark;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class SeudoSpark {
    
    public static void get(String route, BiFunction<HttpRequest, HttpResponse, String> body){
        SeudoSparkServer server = SeudoSparkServer.getInstance();
        server.get(route, body);
    }

    public static void port(int port){
        SeudoSparkServer server = SeudoSparkServer.getInstance();
        server.port(port);
    }

    public static void startServer(){
        SeudoSparkServer server = SeudoSparkServer.getInstance();
        server.startServer();
    }

}
