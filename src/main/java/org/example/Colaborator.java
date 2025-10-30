package org.example;

public class Colaborator extends Antrenor{
    private String companie;

    public Colaborator(String nume, String specializare, int age, TipAngajat tip, String companie) {
        super(nume, specializare, age, tip);
        this.companie = companie;
    }
}
