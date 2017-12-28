package com.javastart.schronisko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class AnimalRepository {

    private List<Animal> animals;

    public AnimalRepository() {
        animals = new ArrayList<>();

        animals.add(new Animal( "Grunio", Category.PIES));
        animals.add(new Animal("Grunio2"));
        animals.add(new Animal("Grunio2", "Customowy opis"));
        animals.add(new Animal("Klakier","Opis", Category.INNE));
        animals.add(new Animal("Mops"));
        animals.add(new Animal("Mruczek"));
        animals.add(new Animal("Reksio"));
        animals.add(new Animal("Kasztan"));
        animals.add(new Animal("Szczurek"));
    }

    public List<Animal> getAll() {
        return animals;
    }

    public Animal findById(Long id) {
        // TODO zwróć poprawnego zwierzaka
        int idd = Math.toIntExact(id);
        return animals.get(idd);
    }

    public void addAnimal(Animal wypelnionyZwierzak) {
        animals.add(wypelnionyZwierzak);
    }

    public List<Animal> searchBy(Animal szukanyZwierzak) {
        List<Animal> result = animals.stream().filter(animal -> szukanyZwierzak.category.equals(animal.getCategory()))
                .filter(animal -> animal.getName().toLowerCase().contains(szukanyZwierzak.getName().toLowerCase()))
                .collect(Collectors.toList());
        return result;
        //TODO za razie zwraca wszystko
//        return animals;
    }
}
