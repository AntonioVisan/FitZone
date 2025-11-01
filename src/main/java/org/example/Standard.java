package org.example;

public class Standard extends Abonament{
    private String tip;
    private double pret;
    private int durataLuni;

    public Standard(double pret, int durataLuni) {
        super(pret, durataLuni);
    }

    public String getTip()
    {
        return tip;
    }

}
