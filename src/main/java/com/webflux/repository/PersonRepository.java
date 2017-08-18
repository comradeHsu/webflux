package com.webflux.repository;

import com.webflux.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */
//@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person,String>{
   /** @Autowired
    private MongoTemplate mongoTemplate;

    public Flux<Person> findAll(){
        List<Person> list = mongoTemplate.findAll(Person.class);
        return Flux.fromIterable(list);
    }

    public Mono<Person> findByName(String name){
        Query query = Query.query(Criteria.where("name").is(name));
        Person person = mongoTemplate.find(query,Person.class).get(0);
        return Mono.justOrEmpty(person);
    }

    public Mono<Void> update(Person person){
       mongoTemplate.save(person);
       return Mono.empty();
    }

    public Mono<Person> delete(String id){
        Query query = Query.query(Criteria.where("id").is(id));
        return Mono.justOrEmpty(mongoTemplate.findAndRemove(query,Person.class));
    }
   **/

   Mono<Person> findByName(String name);

   Mono<Void>
}
