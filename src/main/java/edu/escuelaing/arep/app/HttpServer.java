package edu.escuelaing.arep.app;

import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class HttpServer {
    private int port;

    Map<String, Processor> routesToProcessors = new HashMap();

        /**
         * This method handle and implements the http server
         * @param port
         * @throws IOException
         */
    public void startServer(int port) throws IOException {
        this.port = port;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000. "+e.toString());
            System.exit(1);
        }

        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ..." + port);
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;

            boolean isfirst = true;
            String path = "";

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Recibí: " + inputLine);
                if (isfirst) {
                    path = inputLine.split(" ")[1];
                    isfirst = false;
                }
                if (!in.ready()) {
                    break;
                }
            }
            String resp = "";
            for(String key: routesToProcessors.keySet()){
                if(path.startsWith(key)){
                    System.out.println("Holaaaaaaaaaaaaa "+path.substring(key.length()));
                    String newPath = path.substring(key.length());
                    resp = routesToProcessors.get(key).handle(newPath, null , null);
                }
            }

            if(resp==null){
                outputLine = validHttpRequest();
            } else {
                outputLine = resp;
            }

            
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    /**
     * Return the port of this server
     * @return int
     */
    private int getPort() {
        return port;
    }

    /**
     * This methos set the port  of the server
     * @param port int
     */
    private void setPort(int port) {
        this.port = port;
    }

    /**
     * This methos register the processor that handle the requests
     * @param path request path of the client
     * @param processor procesor that handle the request
     */
    public void registerProcessor(String path, Processor processor) {
        routesToProcessors.put(path, processor);
    }

    /**
     * Valid request tamplate
     * @return String
     */
    public String validHttpRequest() {
        return "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n" + "\r\n" + "<!DOCTYPE html>\n" + "<html>\n"
                + "<head>\n" + "<meta charset=\"UTF-8\">\n" + "<title>Title of the document</title>\n" + "</head>\n"
                + "<body>\n" + "<h1>Mi propio mensaje</h1>\n" + "</body>\n" + "</html>\n";
    }
}