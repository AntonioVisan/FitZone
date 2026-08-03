package org.example;

public class Standard extends Membership {

    public Standard(final double price, final int durationMonths) {
        super(price, durationMonths);
    }

    @Override
    public String getMembershipType() {
        return "Standard";
    }
}
