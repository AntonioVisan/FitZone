package org.example;

public class Standard extends Membership {
    //standard
    public Standard(double pret, int durataLuni) {
        super(pret, durataLuni);
    }

    public String getMembershipType()
    {
        return "Standard";
    }

}
