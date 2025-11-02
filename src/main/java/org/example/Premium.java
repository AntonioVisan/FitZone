package org.example;

public class Premium extends Abonament{
    //premium
    public Premium(double pret, int durataLuni) {
        super(pret, durataLuni);
    }

    public String getTip()
    {
        return "Premium";
    }
}
