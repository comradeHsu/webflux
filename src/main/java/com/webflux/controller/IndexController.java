package com.webflux.controller;

import com.webflux.handler.PersonHandler;
import com.webflux.model.Person;
import com.webflux.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Created by Administrator on 2017/8/15.
 */
@RestController
public class IndexController {
    @Autowired
    PersonHandler personHandler;

//    @GetMapping("/person")
//    public Flux<Person> list() {
//    }
}
