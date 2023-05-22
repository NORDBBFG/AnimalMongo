package com.example.mongoLb3.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "animal")
public class TestAnimal {

    @Id
    private String id;

    private String firstName;
    private String fangs;
    private String wool;
    private int age;
    private String claws;
    private String subspecies;
    private String animalType;
    private String sex;
    private String domestic;

}
