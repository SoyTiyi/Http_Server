package edu.escuelaing.arep.app.SeudoSpark;

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

    private SeudoSparkServer() {
        server.registerProcessor("/Apps",this);
    }

    public static SeudoSparkServer getInstance() {
        return instance;
    }

    public void get(String route, BiFunction<HttpRequest, HttpResponse, String> sup) {
        functions.put(route, sup);
    }

    public void startServer() {
        try {
            server.startServer(httpPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void port(int serverPort) {
        this.httpPort = serverPort;
    }

    public String handle(String path, HttpRequest req, HttpResponse resp) {
        if (functions.containsKey(path)) {
            return httpHeader() + functions.get(path).apply(req , resp);
        }
        return httpError();
    }

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

    private String httpHeader() {
        return "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n" + "\r\n";
    }
}
