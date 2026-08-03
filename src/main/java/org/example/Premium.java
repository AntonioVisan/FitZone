package org.example;

public class Premium extends Membership {

    public Premium(final double price, final int durationMonths) {
        super(price, durationMonths);
    }

    @Override
    public String getMembershipType() {
        return "Premium";
    }
}
