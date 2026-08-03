package org.example;

import java.util.List;
import java.util.Scanner;

public interface Fitness {

    void hireTrainer(final Trainer trainer);

    void addWorkout(final Workout workout);

    void addClient(final Client client);

    void addTrainer(final Scanner input);

    void addClient(final Scanner input);

    void addMembershipForClient(final Scanner input);

    void addWorkout(final Scanner input);

    void addWorkoutForTrainer(final Scanner input);

    void addWorkoutForClient(final Scanner input);

    Client selectClient(final Scanner input, final String message);

    Trainer selectTrainer(final Scanner input, final String message);

    Workout selectWorkout(final Scanner input, final Client client);

    Workout selectWorkout(final Scanner input, final Trainer trainer);
    
    void displayMemberships();

    void displayTrainers();

    void displayWorkouts();

    void displayWorkouts(final String name);

    List<Client> getClients();

    List<Trainer> getTrainers();

    List<Workout> getWorkouts();

    List<Workout> getAvailableWorkoutsByName(final String name);

    void displayClients();

    void displayClientDetails();

    void generateReport();
}
