package edu.escuelaing.arep.app;

import static edu.escuelaing.arep.app.SeudoSpark.SeudoSpark.*;

public class DemoServer {
    public static void main(String[] args) {
        port(getPort());
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
