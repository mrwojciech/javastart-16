package com.javastart.schronisko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {

    private List<Animal> animals;

    public AnimalRepository() {
        animals = new ArrayList<>();

        animals.add(new Animal( "Grunio"));
        animals.add(new Animal("Grunio2"));
        animals.add(new Animal("Grunio2", "Customowy opis"));
        animals.add(new Animal("Klakier"));
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
        //pomniejszone gdyz indeksowanie zaczyna sie od 1
        return animals.get(idd);
    }

    public void addAnimal(Animal wypelnionyZwierzak) {
        animals.add(wypelnionyZwierzak);
    }
}
