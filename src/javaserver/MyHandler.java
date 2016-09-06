/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaserver;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Steve
 */
public class MyHandler implements HttpHandler {

    private static final Logger LOG = LogManager.getRootLogger();

    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = "I'm alive!";
        LOG.info("REQUEST\t"+t.getRequestMethod()+"\t"+t.getRemoteAddress().getHostString()+"\t["+t.getRequestHeaders().getFirst("User-Agent")+"]");
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
        LOG.info("RESPONSE\t"+t.getResponseCode());
        t.close();
    }
}
