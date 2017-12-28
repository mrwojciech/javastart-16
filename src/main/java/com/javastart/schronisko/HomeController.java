package com.javastart.schronisko;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private AnimalRepository animalRepository;

    @Autowired
    public HomeController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Animal> listOfAllAnimals = animalRepository.getAll();
        model.addAttribute("model", listOfAllAnimals);
        return "home";
    }

}
