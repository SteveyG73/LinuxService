/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaserver;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

/**
 *
 * @author Steve
 */
public class JavaServer {

    private static final Logger LOG = LogManager.getRootLogger();
    private static HttpServer server;

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                LOG.info("Shutting down server");
                server.stop(5);
                LOG.info("Shutdown complete");
            }
        });

        LOG.info("Starting server on port 8181");
        server = HttpServer.create(new InetSocketAddress(8181), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null); // creates a default executor
        LOG.info("Access server via http://" + server.getAddress().getAddress().getCanonicalHostName() + ":" + server.getAddress().getPort() + "/test");
        server.start();
    }

}
