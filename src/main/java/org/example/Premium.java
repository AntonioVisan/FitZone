package org.example;

public class Premium extends Membership {
    //premium
    public Premium(double pret, int durataLuni) {
        super(pret, durataLuni);
    }

    public String getMembershipType()
    {
        return "Premium";
    }
}
