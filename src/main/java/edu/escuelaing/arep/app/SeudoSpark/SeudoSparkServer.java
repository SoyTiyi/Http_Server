package edu.escuelaing.arep.app.SeudoSpark;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.arep.app.HttpServer;

public class SeudoSparkServer {
    private int httpPort;
    private static SeudoSparkServer instance = new SeudoSparkServer();

    private SeudoSparkServer() {
    }

    public static SeudoSparkServer getInstance() {
        return instance;
    }

    Map<String, String> functions = new HashMap();
    HttpServer server = new HttpServer();

    public void get(String route, String body) {
        functions.put(route, body);
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


}
