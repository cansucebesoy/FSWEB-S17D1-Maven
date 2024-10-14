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
    private String developerFullName;

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/animal")
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }

    @GetMapping("/animal/{id}")
    public Animal findAnimalByiId(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping("/animal")
    public Animal createAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/animal/{id}")
    public Animal saveAnimal(@PathVariable Integer id, @RequestBody Animal animal){
        animals.put(id, new Animal(id, animal.getName()));
        return animals.get(id);
    }

    @DeleteMapping("/animal/{id}")
    public Animal deleteAnimal(@PathVariable Integer id){
        Animal animal = animals.get(id);
        animals.remove(id);
        return animal;
    }


}
