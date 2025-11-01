package org.example;

public abstract class Abonament {

    private double pret;
    private int durataLuni;

    public Abonament(double pret, int durataLuni)
    {
        this.pret = pret;
        this.durataLuni = durataLuni;
    }

    public abstract String getTip();

    public double getPret() {
        return pret;
    }

    public int getDurataLuni() {
        return durataLuni;
    }
}
