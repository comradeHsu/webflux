package com.webflux.config;

import com.webflux.handler.PersonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by Administrator on 2017/8/16.
 */
@Configuration
public class Routes {
    @Autowired
    private PersonHandler personHandler;

    @Bean
    public RouterFunction<?> routerFunction(){
        return route(GET("/api/persons").and(accept(MediaType.APPLICATION_JSON)),personHandler::listPeople)
                .and(route(GET("/api/person/{name}").and(accept(MediaType.APPLICATION_JSON)),personHandler::findByName)
                .and(route(POST("/api/person/update").and(accept(MediaType.APPLICATION_JSON)),personHandler::update)
                        .and(route(DELETE("/api/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),personHandler::delete))));
    }
}
