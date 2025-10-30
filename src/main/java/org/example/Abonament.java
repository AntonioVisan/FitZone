package org.example;

public class Abonament {
    private String tip;
    private double pret;
    private int durataLuni;

    public Abonament(String tip, double pret, int durataLuni) {
        this.tip = tip;
        this.pret = pret;
        this.durataLuni = durataLuni;
    }

    public String getTip() {
        return tip;
    }

    public double getPret() {
        return pret;
    }

    public int getDurataLuni() {
        return durataLuni;
    }


}
