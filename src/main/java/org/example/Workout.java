package org.example;

public class Workout {
    public enum IntensityLevel {
        EASY,
        MEDIUM,
        HARD
    }

    private static final double DISCOUNT_RATE = 0.10;
    private static final int DISCOUNT_THRESHOLD = 3;

    private final String name;
    private final int durationMinutes;
    private final IntensityLevel intensityLevel;
    private double price;
    private Trainer trainer;

    public Workout(final String name, final int durationMinutes,
                   final IntensityLevel intensityLevel, final double price) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Workout name cannot be empty.");
        }

        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        if (intensityLevel == null) {
            throw new IllegalArgumentException("Intensity level cannot be null.");
        }

        this.name = name;
        this.durationMinutes = durationMinutes;
        this.intensityLevel = intensityLevel;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %d minutes, %s, %.2f RON%s",
                name,
                durationMinutes,
                intensityLevel,
                price,
                trainer == null
                        ? ", No trainer assigned"
                        : ", Trainer: " + trainer.getName()
        );
    }

    public IntensityLevel getIntensityLevel() {
        return intensityLevel;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(final Trainer trainer) {
        if (trainer == null) {
            throw new IllegalArgumentException("Trainer cannot be null.");
        }

        this.trainer = trainer;
    }

    /**
     * Applies the workout discount.
     */
    public void applyDiscount() {
        System.out.printf(
                "%.0f%% discount has been applied for purchasing %d workouts.%n",
                DISCOUNT_RATE * 100,
                DISCOUNT_THRESHOLD
        );

        System.out.printf("Original price: %.2f RON%n", price);

        price *= (1 - DISCOUNT_RATE);

        System.out.printf("Discounted price: %.2f RON%n", price);
    }
}
