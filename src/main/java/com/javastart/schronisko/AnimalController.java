package com.javastart.schronisko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/szukajZwierzaka")
    public String searchForAnimal(Model model) {
        Animal pustyZwierzak = new Animal();
        model.addAttribute("pustyZwierzak", pustyZwierzak);
        return "searchAnimalForm";
    }

    @PostMapping("/szukamZwierzaka")
    public String searchForGivenAnimal(Animal szukanyZwierzak, Model model) {
        List<Animal> result = animalRepository.searchBy(szukanyZwierzak);
        model.addAttribute("model", result);
        return "resultsFromSearch";
    }

    @PostMapping("/dopisujeZwierzaka")
    public String dodawanieZwierzaka(Animal wypelnionyZwierzak) {
        wypelnionyZwierzak.increaseIdCounter();
        wypelnionyZwierzak.setId(wypelnionyZwierzak.getIdCounter());
        animalRepository.addAnimal(wypelnionyZwierzak);
        return "dodano";
    }
}
