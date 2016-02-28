package ua.prom;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Created by denys on 27.02.16.
 */
public class MainLoader {

    public static String HOST = "http://localhost:8084/";

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.bugysantas.salesman package
        final ResourceConfig rc = new ResourceConfig().packages("ua.prom.resources");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(HOST), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", HOST));
        System.in.read();
        server.stop();
    }


}
