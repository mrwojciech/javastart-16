package com.javastart.schronisko;

public class Animal {

    private static Long idCounter = -1L;
    private Long id;
    private String name;
    private String desc;

    public Animal() {
        this.id = idCounter;
        this.desc = "Tu jest miejsce na opis";
    }


    public Animal(String name, String desc) {
        idCounter++;
        this.name = name;
        this.desc = desc;
        this.id = idCounter;
    }

    public Animal(String name) {
        idCounter++;
        this.id = idCounter;
        this.name = name;
        this.desc = "Tu jest miejsce na opis";
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public  Long getIdCounter() {
        return idCounter;
    }

    public  void setIdCounter(Long idCounter) {
        this.idCounter = idCounter;
    }

    public  void increaseIdCounter() {
        this.idCounter++;
    }
}
