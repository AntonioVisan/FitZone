package org.example;

import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);
        final FitZone fitZone = new FitZone();

        while (true) {
            System.out.println();
            System.out.println("Choose an option:");
            System.out.println("1) Add trainer.");
            System.out.println("2) Add client.");
            System.out.println("3) Add membership to an existing client.");
            System.out.println("4) Add workout.");
            System.out.println("5) Assign workout to an existing trainer.");
            System.out.println("6) Assign workout to an existing client.");
            System.out.println("7) Display client memberships.");
            System.out.println("8) Display trainers.");
            System.out.println("9) Display workouts.");
            System.out.println("10) Display clients.");
            System.out.println("11) Generate report.");
            System.out.println("12) Exit.");

            final int option = input.nextInt();
            input.nextLine();

            if (option == 12) {
                System.out.println("Closing application. Goodbye!");
                break;
            }

            switch (option) {
                case 1 -> fitZone.addTrainer(input);
                case 2 -> fitZone.addClient(input);
                case 3 -> fitZone.addMembershipForClient(input);
                case 4 -> fitZone.addWorkout(input);
                case 5 -> fitZone.addWorkoutForTrainer(input);
                case 6 -> fitZone.addWorkoutForClient(input);
                case 7 -> {
                    System.out.println("Client memberships:");
                    fitZone.displayMemberships();
                }
                case 8 -> {
                    System.out.println("Trainers:");
                    fitZone.displayTrainers();
                }
                case 9 -> {
                    System.out.println("Workouts:");
                    fitZone.displayWorkouts();
                }
                case 10 -> {
                    System.out.println("Clients:");
                    fitZone.displayClientDetails();
                }
                case 11 -> fitZone.generateReport();
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }
}