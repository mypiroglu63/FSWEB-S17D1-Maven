package com.workintech.fswebs17d1.controller;
import com.workintech.fswebs17d1.entity.Animal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/animal/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    @GetMapping("/animal")
    public List<Animal> getAllAnimals() {
        return animals.values().stream().toList();
    }


    @PostMapping("/animal")
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }


    @PutMapping("/animal/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        animals.put(id, animal);
        return animals.get(id);
    }

    // [DELETE] /workintech/animal/{id} => İlgili id değerini mapten siler.
    @DeleteMapping("/animal/{id}")
    public Animal deleteAnimal(@PathVariable Integer id) {
        return animals.remove(id);
    }

    // Additional endpoint to check course name and developer name
    @GetMapping("/info")
    public String getInfo() {
        return "Course Name: " + courseName + ", Developer: " + developerName;
    }
}
