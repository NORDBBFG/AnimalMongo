package com.example.mongoLb3.controller;

import com.example.mongoLb3.model.TestAnimalDTO;
import com.example.mongoLb3.model.TestAnimal;
import com.example.mongoLb3.repository.TestMongoRepository;
import com.example.mongoLb3.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestMongoRepository testMongoRepository;

    @PostMapping("/animal")
    public TestAnimal createDocument(@RequestBody TestAnimalDTO testAnimalDTO) {
        return testService.create(testAnimalDTO);
    }

    @PutMapping("/animal")
    public TestAnimal updateDocument(@RequestBody TestAnimalDTO testAnimalDTO, @RequestParam String id) {
        return testService.update(testAnimalDTO, id);
    }

    @DeleteMapping("/animal")
    public void delete(@RequestParam String id) {
        testService.delete(id);
    }

    @GetMapping("/animalGetAll")
    public @ResponseBody
    List<TestAnimal> getEmployees()
    {
        List<TestAnimal> result = testMongoRepository.findAll();
        List<TestAnimal> employeesList = new ArrayList<TestAnimal>();
        employeesList.addAll(result);
        return employeesList;
    }

    @GetMapping("/animal")
    public TestAnimal find(@RequestParam String id) {
        return testService.find(id);
    }

}
