package com.javastart.schronisko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimalController {

    @Autowired AnimalRepository animalRepository;

    @RequestMapping("/zwierzak")
    public String singleAnimal(@RequestParam Long id, Model model) {
        Animal animal = animalRepository.findById(id);
        model.addAttribute("animal", animal);
        return "animal";
    }

    @GetMapping("/dodajZwierzaka")
    public String addAnimal(Model model) {
        Animal pustyZwierzak = new Animal();
        model.addAttribute("pustyZwierzak", pustyZwierzak);
        return "addAnimalForm";
    }

    @PostMapping("/dopisujeZwierzaka")
    public String dodawanieZwierzaka(Animal wypelnionyZwierzak) {
        wypelnionyZwierzak.increaseIdCounter();
        wypelnionyZwierzak.setId(wypelnionyZwierzak.getIdCounter());
        animalRepository.addAnimal(wypelnionyZwierzak);
        return "dodano";
    }
}
