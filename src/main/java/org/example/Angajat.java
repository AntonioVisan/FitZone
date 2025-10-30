package org.example;

public class Angajat extends Antrenor{
    private double salariu;

    public Angajat(String nume, String specializare, Integer age, TipAngajat tip, double salariu) {
        super(nume, specializare, age, tip);
        this.salariu = salariu;
    }
}
