package org.example;

public class Angajat extends Trainer{
    private final double salariu; //salariu

    public Angajat(String nume, String specializare, Integer age, double salariu) {
        super(nume, specializare, age);
        this.salariu = salariu;
    }

    public double getSalariu() {
        return salariu;
    }

    public String getTrainerType()
    {
        return "Angajat permanent";
    }
}
