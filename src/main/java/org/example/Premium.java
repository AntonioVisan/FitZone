package org.example;

public class Premium extends Abonament{
    private String tip;

    public Premium(double pret, int durataLuni) {
        super(pret, durataLuni);
    }

    public String getTip()
    {
        return "Premium";
    }
}
