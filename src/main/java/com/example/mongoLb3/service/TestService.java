package com.example.mongoLb3.service;

import com.example.mongoLb3.model.TestAnimalDTO;
import com.example.mongoLb3.model.TestAnimal;
import com.example.mongoLb3.repository.TestMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private TestMongoRepository testMongoRepository;

    public TestAnimal create(TestAnimalDTO testAnimalDTO) {
        TestAnimal testAnimal = new TestAnimal();
        testAnimal.setFirstName(testAnimalDTO.getFirstName());
        testAnimal.setFangs(testAnimalDTO.getFangs());
        testAnimal.setWool(testAnimalDTO.getWool());
        testAnimal.setAge(testAnimalDTO.getAge());
        testAnimal.setClaws(testAnimalDTO.getClaws());
        testAnimal.setSubspecies(testAnimalDTO.getSubspecies());
        testAnimal.setAnimalType(testAnimalDTO.getAnimalType());
        testAnimal.setSex(testAnimalDTO.getSex());
        testAnimal.setDomestic(testAnimalDTO.getDomestic());
        testMongoRepository.save(testAnimal);
        return testAnimal;
    }

    public TestAnimal update(TestAnimalDTO testAnimalDTO, String operationID) {
        Optional<TestAnimal> optionalTestMongoDocument = testMongoRepository.findById(operationID);
        if(optionalTestMongoDocument.isPresent()) {
            TestAnimal testAnimal = optionalTestMongoDocument.get();
            testAnimal.setFirstName(testAnimalDTO.getFirstName());
            testAnimal.setFangs(testAnimalDTO.getFangs());
            testAnimal.setWool(testAnimalDTO.getWool());
            testAnimal.setAge(testAnimalDTO.getAge());
            testAnimal.setClaws(testAnimalDTO.getClaws());
            testAnimal.setSubspecies(testAnimalDTO.getSubspecies());
            testAnimal.setAnimalType(testAnimalDTO.getAnimalType());
            testAnimal.setSex(testAnimalDTO.getSex());
            testAnimal.setDomestic(testAnimalDTO.getDomestic());
            testMongoRepository.save(testAnimal);
            return mongoTemplate.save(testAnimal);
        }
        return null;
    }

    public void delete(String operationID) {
        testMongoRepository.deleteById(operationID);
    }

    public TestAnimal find(String operationID) {
        return testMongoRepository.findById(operationID).get();
    }

}
