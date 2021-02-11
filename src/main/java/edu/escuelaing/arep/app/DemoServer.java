package edu.escuelaing.arep.app;

import static edu.escuelaing.arep.app.SeudoSpark.SeudoSpark.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DemoServer {
    public static void main(String[] args) throws IOException {
        port(getPort());
        File htmlPage = new File(System.getProperty("user.dir"),"src/main/resources/public/index.html");
        FileReader reader = new FileReader(htmlPage);
        BufferedReader br = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
            sb.append("\n");
        }
        reader.close();
        get("", (req, resp) -> sb.toString());
        get("/hello", (req , resp) -> "Hello World mundillo lamda");
        startServer();
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000;
    }
}
