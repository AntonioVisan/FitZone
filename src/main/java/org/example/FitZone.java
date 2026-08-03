package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitZone implements Fitness {

    private final List<Trainer> trainers;
    private final List<Client> clients;
    private final List<Workout> workouts;

    public FitZone() {
        trainers = new ArrayList<>();
        clients = new ArrayList<>();
        workouts = new ArrayList<>();
    }

    @Override
    public void hireTrainer(final Trainer trainer) {
        trainers.add(trainer);
    }

    @Override
    public void addWorkout(final Workout workout) {
        workouts.add(workout);
    }

    @Override
    public void addClient(final Client client) {
        clients.add(client);
    }

    @Override
    public void addTrainer(final Scanner input) {
        System.out.println("Enter trainer name: ");
        String name = input.nextLine();
        System.out.println("Enter trainer specialization: ");
        String specialization = input.nextLine();
        System.out.println("Enter trainer age: ");
        int age = input.nextInt();
        input.nextLine();
        while (true) {
            System.out.println("Choose trainer type:");
            System.out.println("1) Permanent employee");
            System.out.println("2) External collaborator");
            int option = input.nextInt();
            input.nextLine();
            if (option == 1) {
                System.out.println("Enter employee salary:");
                double salary = input.nextDouble();
                input.nextLine();
                hireTrainer(new Employee(name, specialization, age, salary));
                System.out.println("Trainer hired successfully.");
                break;
            } else if (option == 2) {
                System.out.println("Enter collaborator company:");
                String company = input.nextLine();
                hireTrainer(new Collaborator(name, specialization, age, company));
                System.out.println("Collaborator hired successfully.");
                break;
            } else {
                System.out.println("Invalid value. Please enter a valid option.");
            }
        }
    }

    @Override
    public Client selectClient(final Scanner input, final String message) {
        if (getClients().isEmpty()) {
            System.out.println("No clients registered.");
            return null;
        }
        System.out.println(message);
        displayClients();
        int clientIndex = input.nextInt();
        input.nextLine();
        if (clientIndex < 1 || clientIndex > getClients().size()) {
            System.out.println("Invalid index for client. Please try again.");
            return null;
        }
        return getClients().get(clientIndex - 1);
    }

    @Override
    public void addClient(final Scanner input) {
        System.out.println("Enter client name: ");
        String name = input.nextLine();
        System.out.println("Enter client age: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("Enter membership price: ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.println("Enter membership duration (months): ");
        int durationMonths = input.nextInt();
        input.nextLine();
        while (true) {
            System.out.println("Enter the desired membership type for client: ");
            System.out.println("1) Standard Membership.");
            System.out.println("2) Premium Membership.");
            int option = input.nextInt();
            input.nextLine();
            if (option == 1) {
                addClient(new Client(name, age, new Standard(price, durationMonths)));
                System.out.println("The client and Standard membership have been added successfully.");
                break;
            } else if (option == 2) {
                addClient(new Client(name, age, new Premium(price, durationMonths)));
                System.out.println("The client and Premium membership have been added successfully.");
                break;
            } else {
                System.out.println("Invalid value. Please enter a valid option.");
            }
        }
    }

    @Override
    public void addMembershipForClient(final Scanner input) {
        Client client = selectClient(input, "Select the index of the client for whom you want to add a membership: ");
        if (client == null) {
            return;
        }
        System.out.println("Enter the price of the membership: ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.println("Enter membership duration (months): ");
        int durationMonths = input.nextInt();
        input.nextLine();
        while (true) {
            System.out.println("Enter the desired membership type: ");
            System.out.println("1) Standard Membership.");
            System.out.println("2) Premium Membership.");
            int option = input.nextInt();
            input.nextLine();
            if (option == 1) {
                Membership standard = new Standard(price, durationMonths);
                standard.applyDiscount();
                client.addMembership(standard);
                System.out.println("Standard membership added successfully.");
                break;
            } else if (option == 2) {
                Membership premium = new Premium(price, durationMonths);
                premium.applyDiscount();
                client.addMembership(premium);
                System.out.println("Premium membership added successfully.");
                break;
            } else System.out.println("Invalid value. Please enter a valid option.");
        }
    }

    @Override
    public void addWorkoutForClient(final Scanner input) {
        Client client = selectClient(input, "Select the index of the client for whom you want to add a workout: ");

        if (client == null) {
            return;
        }

        Workout workout = selectWorkout(input, client);
        if (workout == null) {
            return;
        }

        // Apply a discount after every third purchased workout.
        if (client.getPurchasedWorkoutsCount() % 3 == 0 && client.getPurchasedWorkoutsCount() > 0) {
            workout.applyDiscount();
        }

        client.addWorkout(workout);
        System.out.println("Workout added successfully to client " + client.getName() + ".");
    }

    @Override
    public Trainer selectTrainer(final Scanner input, final String message) {
        if (getTrainers().isEmpty()) {
            System.out.println("No trainers registered.");
            return null;
        }
        System.out.println(message);
        displayTrainers();
        int trainerIndex = input.nextInt();
        input.nextLine();
        if (trainerIndex < 1 || trainerIndex > getTrainers().size()) {
            System.out.println("Invalid index for trainer. Please try again.");
            return null;
        }
        return getTrainers().get(trainerIndex - 1);
    }

    @Override
    public Workout selectWorkout(final Scanner input, final Client client) {
        System.out.println("Select the index of the workout you want to assign to the client " + client.getName() + ": ");
        displayWorkouts();
        int indexWorkout = input.nextInt();
        input.nextLine();
        if (indexWorkout < 1 || indexWorkout > getWorkouts().size()) {
            System.out.println("Invalid index for workout. Please try again.");
            return null;
        }
        return getWorkouts().get(indexWorkout - 1);
    }

    @Override
    public Workout selectWorkout(final Scanner input, final Trainer trainer) {
        List<Workout> availableWorkouts = getAvailableWorkoutsByName(trainer.getSpecialization());
        if (availableWorkouts.isEmpty()) {
            System.out.println("No workouts registered.");
            return null;
        }

        System.out.println("Select the index of the workout you want to assign to the trainer " + trainer.getName() + ": ");
        displayWorkouts(trainer.getSpecialization());
        int indexWorkout = input.nextInt();
        input.nextLine();
        if (indexWorkout < 1 || indexWorkout > availableWorkouts.size()) {
            System.out.println("Invalid index for workout. Please try again.");
            return null;
        }
        return availableWorkouts.get(indexWorkout - 1);
    }

    @Override
    public void addWorkoutForTrainer(final Scanner input) {
        Trainer trainer = selectTrainer(input, "Select the index of the trainer for whom you want to add a workout: ");

        if (trainer == null) {
            return;
        }

        Workout workout = selectWorkout(input, trainer);

        if (workout == null) {
            return;
        }

        workout.setTrainer(trainer);
        trainer.addWorkout(workout);
        System.out.println("Workout added successfully to trainer " + trainer.getName() + ".");
    }

    @Override
    public void addWorkout(final Scanner input) {
        System.out.println("Enter the name of the workout: ");
        String name = input.nextLine();
        System.out.println("Enter the duration of the workout in minutes: ");
        int durationMinutes = input.nextInt();
        input.nextLine();
        System.out.println("Enter the price of the workout: ");
        double price = input.nextDouble();
        input.nextLine();
        while (true) {
            System.out.println("Enter the intensity level of the workout:");
            System.out.println("1) Easy");
            System.out.println("2) Medium");
            System.out.println("3) Hard");
            int intensityLevel = input.nextInt();
            input.nextLine();
            if (intensityLevel == 1) {
                addWorkout(new Workout(name, durationMinutes, Workout.IntensityLevel.EASY, price));
                System.out.println("The Easy Workout has been added successfully.");
                break;
            } else if (intensityLevel == 2) {
                addWorkout(new Workout(name, durationMinutes, Workout.IntensityLevel.MEDIUM, price));
                System.out.println("The Medium Workout has been added successfully.");
                break;
            } else if (intensityLevel == 3) {
                addWorkout(new Workout(name, durationMinutes, Workout.IntensityLevel.HARD, price));
                System.out.println("The Hard Workout has been added successfully.");
                break;
            } else {
                System.out.println("Invalid value. Please enter a valid option.");
            }
        }
    }

    @Override
    public void displayMemberships() {
        if (clients.isEmpty()) {
            System.out.println("No clients registered.");
            return;
        }
        for (Client client : clients) {
            System.out.println("Memberships purchased by " + client.getName() + ":");
            for (Membership membership : client.getMemberships()) {
                System.out.println("- " + membership.getMembershipType());
            }
            System.out.println();
        }
    }

    @Override
    public void displayTrainers() {
        if (trainers.isEmpty()) {
            System.out.println("No trainers registered.");
            return;
        }

        int indexTrainer = 1;

        for (Trainer trainer : trainers) {
            System.out.print(indexTrainer++ + ". ");

            if (trainer instanceof Employee employee) {
                System.out.println(
                        "Trainer: " + trainer.getName()
                                + " | Age: " + trainer.getAge()
                                + " | Specialization: " + trainer.getSpecialization()
                                + " | Type: " + trainer.getTrainerType()
                                + " | Salary: " + String.format("%.2f lei", employee.getSalary())
                );
            } else if (trainer instanceof Collaborator collaborator) {
                System.out.println(
                        "Trainer: " + trainer.getName()
                                + " | Age: " + trainer.getAge()
                                + " | Specialization: " + trainer.getSpecialization()
                                + " | Type: " + trainer.getTrainerType()
                                + " | Company: " + collaborator.getCompany()
                );
            }

            if (trainer.getWorkouts().isEmpty()) {
                System.out.println("This trainer does not teach any workouts.");
            } else {
                System.out.println("Assigned workouts:");
                for (Workout workout : trainer.getWorkouts()) {
                    System.out.println("- " + workout);
                }
            }

            System.out.println();
        }
    }

    @Override
    public void displayWorkouts() {
        if (workouts.isEmpty()) {
            System.out.println("No workouts registered.");
            return;
        }
        int indexWorkout = 1;
        for (Workout workout : workouts) {
            System.out.println(indexWorkout++ + ". " + workout);
        }
    }

    @Override
    public void displayWorkouts(final String name) {
        int indexWorkout = 1;
        for (Workout workout : workouts) {
            if (workout.getTrainer() == null && workout.getName().equals(name)) {
                System.out.println(indexWorkout++ + ". " + workout);
            }
        }
    }

    @Override
    public List<Workout> getWorkouts() {
        return workouts;
    }

    @Override
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public List<Trainer> getTrainers() {
        return trainers;
    }

    @Override
    public List<Workout> getAvailableWorkoutsByName(final String name) {
        List<Workout> availableWorkouts = new ArrayList<>();
        for (Workout workout : workouts) {
            if (workout.getName().equals(name) && workout.getTrainer() == null) {
                availableWorkouts.add(workout);
            }
        }
        return availableWorkouts;
    }

    @Override
    public void displayClients() {
        int clientIndex = 1;
        for (Client client : clients) {
            System.out.println(clientIndex++ + ". " + client);
        }
    }

    @Override
    public void displayClientDetails() {
        if (clients.isEmpty()) {
            System.out.println("No clients registered.");
            return;
        }
        int index = 1;
        for (Client client : clients) {
            System.out.println(index++ + ". " + client);
            if (client.getMemberships().isEmpty()) {
                System.out.println("This client does not have any memberships.");
            } else {
                System.out.println("The memberships purchased by this client are:");
                for (Membership membership : client.getMemberships()) {
                    System.out.println("- " + membership.getMembershipType());
                }
            }

            if (client.getPurchasedWorkoutsCount() == 0) {
                System.out.println("This client has not purchased any workouts.");
            } else {
                System.out.println("The workouts purchased by this client are:");
                for (Workout workout : client.getWorkouts()) {
                    System.out.println(workout);
                }
            }

            System.out.println();
        }
    }

    @Override
    public void generateReport() {
        if (workouts.isEmpty()) {
            System.out.println("No workouts registered.");
            return;
        }
        System.out.println("FitZone Report:");
        for (Workout workout : workouts) {
            boolean trainersAvailable = false;
            System.out.println("For the workout: " + workout.getName());
            for (Trainer trainer : trainers) {
                if (trainer.getSpecialization().equals(workout.getName())) {
                    trainersAvailable = true;
                    System.out.println("The trainer " + trainer.getName() + " is available to teach this workout.");
                }
            }
            if (!trainersAvailable) {
                System.out.println("No trainers available to teach this workout.");
            }
        }
    }
}
