package com.company;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by bandi on 26/03/16.
 */
class HttpInput {
    private final HttpServer httpServer;
    private final int PORT = 8000;
    private IOrderTransformer IOrderTransformer;

    HttpInput(Interactor interactor, IOrderTransformer orderTransformer) throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/orders", new ListHttpHandler(interactor, orderTransformer));
        httpServer.setExecutor(null);
    }

    void start() {
        httpServer.start();
        System.out.println("Server is up and listening in " + PORT);
    }

}
