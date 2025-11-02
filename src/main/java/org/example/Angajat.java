package org.example;

public class Angajat extends Antrenor{
    private final double salariu;

    public Angajat(String nume, String specializare, Integer age, double salariu) {
        super(nume, specializare, age);
        this.salariu = salariu;
    }

    public double getSalariu() {
        return salariu;
    }

    public String getTip()
    {
        return "Angajat permanent";
    }
}
