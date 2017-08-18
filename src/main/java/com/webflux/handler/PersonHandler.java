package com.webflux.handler;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mongodb.util.JSON;
import com.webflux.model.Person;
import com.webflux.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public class PersonHandler {
    @Autowired
    PersonRepository personRepository;

    public Mono<ServerResponse> listPeople(ServerRequest request){
        Flux<Person> people = personRepository.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(people,Person.class);
    }

    public Mono<ServerResponse> findByName(ServerRequest request){
        Mono<Person> person = personRepository.findByName(request.pathVariable("name"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(person,Person.class);
    }

    public Mono<ServerResponse> update(ServerRequest request){
        Mono<Void> voidMono = personRepository.update(request.bodyToMono(Person.class).block());
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(voidMono,Void.class);
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        Mono<Void> person = personRepository.deleteById(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(person,Void.class);
    }
}
