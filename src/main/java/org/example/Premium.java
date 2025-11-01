package org.example;

public class Premium extends Abonament{
    private String tip;
    private double pret;
    private int durataLuni;

    public Premium(double pret, int durataLuni) {
        super(pret, durataLuni);
    }

    public String getTip()
    {
        return tip;
    }
}
