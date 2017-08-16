package com.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created by Administrator on 2017/8/15.
 */
@Document(collection = "person")
public class Person implements Serializable {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }

    private String name;
    private Integer age;

    @Field("locs")
    private Collection<Location> locations = new LinkedHashSet<Location>();

    public Person(String name,Integer age){
        super();
        this.name = name;
        this.age = age;
    }
}
