package org.example;

public abstract class Abonament {

    private double pret;
    private int durataLuni;

    public Abonament(double pret, int durataLuni)
    {
        this.pret = pret;
        this.durataLuni = durataLuni;
    }

    public void getInfo()
    {
        System.out.println("Abonamentul "+this.getTip()+" cu pretul "+this.getPret()+" de lei cu durata de "+this.getDurataLuni()+" luni.");
    }
    public abstract String getTip();

    public double getPret() {
        return pret;
    }

    public int getDurataLuni() {
        return durataLuni;
    }
}
