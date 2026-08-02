package org.example;

public class Colaborator extends Trainer{
    //colaborator
    private final String companie;

    public Colaborator(String nume, String specializare, int age, String companie) {
        super(nume, specializare, age);
        this.companie = companie;
    }

    public String getCompanie() {
        return companie;
    }

    public String getTrainerType()
    {
        return "Colaborator extern";
    }
}
