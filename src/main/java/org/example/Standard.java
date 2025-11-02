package org.example;

public class Standard extends Abonament{
    //standard
    public Standard(double pret, int durataLuni) {
        super(pret, durataLuni);
    }

    public String getTip()
    {
        return "Standard";
    }

}
