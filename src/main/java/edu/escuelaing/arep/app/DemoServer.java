package edu.escuelaing.arep.app;

import static edu.escuelaing.arep.app.SeudoSpark.SeudoSpark.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DemoServer {
    public static void main(String[] args) throws IOException {
        port(getPort());
        String main = getFile("index.html");
        get("", (req, resp) -> main);
        String img = getFile("img.html");
        get("img", (req , resp) -> img);
        String css = getFile("index.css");
        get("css", (req, resp) -> css);
        String js = getFile("app.js");
        get("js", (req, resp) -> js);
        startServer();
    }

    /**
     * This method set the port where this app runs 
     * @return port 
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000;
    }

    /**
     * This method return the file that the user want like String
     * @param name of the file
     * @return String 
     * @throws IOException Exception
     */
    static String getFile(String name) throws IOException {
        File htmlPage = new File(System.getProperty("user.dir"),"src/main/resources/public/"+name);
        FileReader reader = new FileReader(htmlPage);
        BufferedReader br = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
            sb.append("\n");
        }
        reader.close();
        return sb.toString();
    }
}
