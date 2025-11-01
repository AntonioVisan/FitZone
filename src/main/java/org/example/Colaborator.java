package org.example;

public class Colaborator extends Antrenor{
    private String companie;

    public Colaborator(String nume, String specializare, int age, String companie) {
        super(nume, specializare, age);
        this.companie = companie;
    }

    public String getCompanie() {
        return companie;
    }

    public void setCompanie(String companie) {
        this.companie = companie;
    }

    public String getTip()
    {
        return "Colaborator extern";
    }
}
