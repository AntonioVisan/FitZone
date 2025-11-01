package org.example;

public class Angajat extends Antrenor{
    private double salariu;

    public Angajat(String nume, String specializare, Integer age, double salariu) {
        super(nume, specializare, age);
        this.salariu = salariu;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu)
    {
        this.salariu = salariu;
    }

    public String getTip()
    {
        return "Angajat permanent";
    }
}
