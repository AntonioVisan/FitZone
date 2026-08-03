package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Trainer {

    private final String name;
    private final String specialization;
    private final int age;
    private final List<Workout> workouts = new ArrayList<>();

    public Trainer(final String name,
                   final String specialization,
                   final int age) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if (specialization == null || specialization.isBlank()) {
            throw new IllegalArgumentException("Specialization cannot be empty.");
        }

        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero.");
        }

        this.name = name;
        this.specialization = specialization;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %s, %d years old (%s)",
                name,
                specialization,
                age,
                getTrainerType()
        );
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getAge() {
        return age;
    }

    public abstract String getTrainerType();

    public void addWorkout(final Workout workout) {
        if (workout == null) {
            throw new IllegalArgumentException("Workout cannot be null.");
        }

        workouts.add(workout);
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }
}
