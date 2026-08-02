package org.example;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final String name;
    private final int age;
    private final List<Membership> memberships = new ArrayList<>();
    private final List<Workout> workouts = new ArrayList<>();

    public Client(final String name, final int age, final Membership membership) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero.");
        }

        if (membership == null) {
            throw new IllegalArgumentException("Membership cannot be null.");
        }

        this.name = name;
        this.age = age;
        this.memberships.add(membership);
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %d years old",
                name,
                age
        );
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void addWorkout(final Workout workout) {
        if (workout == null) {
            throw new IllegalArgumentException("Workout cannot be null.");
        }

        workouts.add(workout);
    }

    public void addMembership(final Membership membership) {
        if (membership == null) {
            throw new IllegalArgumentException("Membership cannot be null.");
        }

        memberships.add(membership);
    }

    public int getPurchasedWorkoutsCount() {
        return workouts.size();
    }
}
