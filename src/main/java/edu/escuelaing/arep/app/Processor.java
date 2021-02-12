package edu.escuelaing.arep.app;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface Processor {
    public String handle(String path, HttpRequest req, HttpResponse resp);
}
