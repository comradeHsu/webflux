package com.webflux.config;

//import org.apache.catalina.Context;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import reactor.ipc.netty.http.server.HttpServer;

/**
 * Created by Administrator on 2017/8/16.
 */
@Configuration
public class HttpServerConfig {
    @Autowired
    private Environment environment;

    @Bean
    public HttpServer httpServer(RouterFunction<?> routerFunction){
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(routerFunction);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer server = HttpServer.create("localhost",8080);
        server.newHandler(adapter);
        return server;
//        HttpHandler httpHandler = RouterFunctions.toHttpHandler(routerFunction);
//        ServletHttpHandlerAdapter servlet = new ServletHttpHandlerAdapter(httpHandler);
//        Tomcat server = new Tomcat();
//        Context rootContext = server.addContext("", System.getProperty("java.io.tmpdir"));
//        Tomcat.addServlet(rootContext, "servlet", servlet);
//        rootContext.addServletMapping("/", "servlet");
//        server.start();
    }
}
