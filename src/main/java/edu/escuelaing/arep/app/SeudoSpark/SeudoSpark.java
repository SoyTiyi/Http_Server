package edu.escuelaing.arep.app.SeudoSpark;

public class SeudoSpark {
    
    public static void get(String route, String body){
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
