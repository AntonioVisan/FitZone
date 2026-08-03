package org.example;

public abstract class Membership {

    private static final double DISCOUNT_RATE = 0.20;
    private static final int DISCOUNT_THRESHOLD_MONTHS = 12;

    private double price;
    private final int durationMonths;

    public Membership(final double price, final int durationMonths) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        if (durationMonths <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }

        this.price = price;
        this.durationMonths = durationMonths;
    }

    @Override
    public String toString() {
        return String.format(
                "%s Membership - Price: %.2f RON, Duration: %d months",
                getMembershipType(),
                price,
                durationMonths
        );
    }

    public abstract String getMembershipType();

    public double getPrice() {
        return price;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    /**
     * Applies the membership discount if the duration
     * meets the required threshold.
     */
    public void applyDiscount() {
        if (durationMonths >= DISCOUNT_THRESHOLD_MONTHS) {
            System.out.printf(
                    "%.0f%% discount has been applied.%n",
                    DISCOUNT_RATE * 100
            );
            System.out.printf("Original price: %.2f RON%n", price);
            price *= (1 - DISCOUNT_RATE);
            System.out.printf("Discounted price: %.2f RON%n", price);
        }
    }
}
