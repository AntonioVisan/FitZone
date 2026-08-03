package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class FitZone implements Fitness {

    private final ArrayList<Trainer> trainers;
    private final ArrayList<Client> clients;
    private final ArrayList<Workout> workouts;

    public FitZone() {
        this.trainers = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.workouts = new ArrayList<>();
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
        System.out.println("Introdu de la tastatura numele antrenorului: ");
        String name = input.nextLine();
        System.out.println("Introdu de la tastatura specializarea antrenorului: ");
        String specialization = input.nextLine();
        System.out.println("Introdu de la tastatura varsta antrenorului: ");
        int age = input.nextInt();
        input.nextLine();
        while (true) {
            System.out.println("Ce antrenor doresti sa angajezi?");
            System.out.println("1) Angajat permanent");
            System.out.println("2) Colaborator extern");
            int option = input.nextInt();
            input.nextLine();
            if (option == 1) {
                System.out.println("Introdu de la tastatura salariul angajatului:");
                double salary = input.nextDouble();
                input.nextLine();
                hireTrainer(new Employee(name, specialization, age, salary));
                System.out.println("Antrenor angajat cu succes.");
                break;
            }
            if (option == 2) {
                System.out.println("Introdu de la tastatura compania colaboratorului:");
                String company = input.nextLine();
                hireTrainer(new Collaborator(name, specialization, age, company));
                System.out.println("Colaborator angajat cu succes.");
                break;
            } else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
        }
    }

    @Override
    public Client selectClient(final Scanner input, final String message) {
        if (getClients().isEmpty()) {
            System.out.println("Nu exista clienti inregistrati.");
            return null;
        }
        System.out.println(message);
        displayClients();
        int clientIndex = input.nextInt();
        input.nextLine();
        if (!(clientIndex >= 1 && clientIndex <= getClients().size())) {
            System.out.println("Index invalid pentru client. Mai incearca o data.");
            return null;
        }
        return getClients().get(clientIndex - 1);
    }

    @Override
    public void addClient(final Scanner input) {
        System.out.println("Introdu de la tastatura numele clientului: ");
        String name = input.nextLine();
        System.out.println("Introdu de la tastatura varsta clientului: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("Introdu de la tastatura pretul abonamentului pentru client: ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.println("Introdu de la tastatura durata in luni a abonamentului pentru client: ");
        int durationMonths = input.nextInt();
        input.nextLine();
        while (true) {
            System.out.println("Introdu de la tastatura tipul abonamentului dorit pentru client: ");
            System.out.println("1) Abonament Standard.");
            System.out.println("2) Abonament Premium.");
            int option = input.nextInt();
            input.nextLine();
            if (option == 1) {
                addClient(new Client(name, age, new Standard(price, durationMonths)));
                System.out.println("Clientul si abonamentul Standard au fost adaugati cu succes.");
                break;
            }
            if (option == 2) {
                addClient(new Client(name, age, new Premium(price, durationMonths)));
                System.out.println("Clientul si abonamentul Premium au fost adaugati cu succes.");
                break;
            } else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
        }
    }

    @Override
    public void addMembershipForClient(final Scanner input) {
        Client client = selectClient(input, "Selecteaza index-ul clientului caruia doresti sa ii adaugi un abonament: ");
        if (client == null)
            return;
        System.out.println("Introdu de la tastatura pretul abonamentului: ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.println("Introdu de la tastatura durata in luni a abonamentului: ");
        int durationMonths = input.nextInt();
        input.nextLine();
        while (true) {
            System.out.println("Introdu de la tastatura tipul abonamentului dorit: ");
            System.out.println("1) Abonament Standard.");
            System.out.println("2) Abonament Premium.");
            int option = input.nextInt();
            input.nextLine();
            if (option == 1) {
                Membership standard = new Standard(price, durationMonths);
                standard.applyDiscount();
                client.addMembership(standard);
                System.out.println("Abonament Standard adaugat cu succes.");
                break;
            }
            if (option == 2) {
                Membership premium = new Premium(price, durationMonths);
                premium.applyDiscount();
                client.addMembership(premium);
                System.out.println("Abonament Premium adaugat cu succes.");
                break;
            } else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
        }
    }

    @Override
    public void addWorkoutForClient(final Scanner input) {
        Client client = selectClient(input, "Selecteaza index-ul clientului caruia doresti sa ii adaugi un antrenament: ");
        if (client == null)
            return;
        Workout workout = selectWorkout(input, client);
        if (workout == null)
            return;
        if (client.getPurchasedWorkoutsCount() % 3 == 0 && client.getPurchasedWorkoutsCount() > 0) //daca are multiplu de 3 antrenamente cumparate, se aplica o reducere de 10% la pret
            workout.applyDiscount();
        client.addWorkout(workout);
        System.out.println("Antrenamentul a fost adaugat cu succes clientului " + client.getName() + ".");
    }

    @Override
    public Trainer selectTrainer(final Scanner input, final String message) {
        if (getTrainers().isEmpty()) {
            System.out.println("Nu exista antrenori inregistrati.");
            return null;
        }
        System.out.println(message);
        displayTrainers();
        int trainerIndex = input.nextInt();
        input.nextLine();
        if (!(trainerIndex >= 1 && trainerIndex <= getTrainers().size())) {
            System.out.println("Index invalid pentru antrenor. Mai incearca o data.");
            return null;
        }
        return getTrainers().get(trainerIndex - 1);
    }

    @Override
    public Workout selectWorkout(final Scanner input, final Client client) {
        System.out.println("Selecteaza index-ul antrenamentului pe care doresti sa-l atribui clientului " + client.getName() + ": ");
        displayWorkouts();
        int indexWorkout = input.nextInt();
        input.nextLine();
        if (!(indexWorkout >= 1 && indexWorkout <= getWorkouts().size())) {
            System.out.println("Index invalid pentru antrenament. Mai incearca o data.");
            return null;
        }
        return getWorkouts().get(indexWorkout - 1);
    }

    @Override
    public Workout selectWorkout(final Scanner input, final Trainer trainer) {
        ArrayList<Workout> availableWorkouts = getAvailableWorkoutsByName(trainer.getSpecialization());
        if (availableWorkouts.isEmpty()) {
            System.out.println("Nu exista antrenamente inregistrate.");
            return null;
        }

        System.out.println("Selecteaza index-ul antrenamentului pe care doresti sa-l atribui antrenorului " + trainer.getName() + ": ");
        displayWorkouts(trainer.getSpecialization());
        int indexWorkout = input.nextInt();
        input.nextLine();
        if (!(indexWorkout >= 1 && indexWorkout <= availableWorkouts.size())) {
            System.out.println("Index invalid pentru antrenament. Mai incearca o data.");
            return null;
        }
        return availableWorkouts.get(indexWorkout - 1);
    }

    @Override
    public void addWorkoutForTrainer(final Scanner input) {
        Trainer trainer = selectTrainer(input, "Selecteaza index-ul antrenorului caruia doresti sa ii adaugi un antrenament: ");
        if (trainer == null)
            return;
        Workout workout = selectWorkout(input, trainer);
        if (workout == null)
            return;
        workout.setTrainer(trainer);
        trainer.addWorkout(workout);
        System.out.println("Antrenamentul a fost atribuit cu succes antrenorului " + trainer.getName() + ".");
    }

    @Override
    public void addWorkout(final Scanner input) {
        System.out.println("Introdu de la tastatura denumirea antrenamentului: ");
        String name = input.nextLine();
        System.out.println("Introdu de la tastatura durata antrenamentului in minute: ");
        int durationMinutes = input.nextInt();
        input.nextLine();
        System.out.println("Introdu de la tastatura pretul antrenamentului: ");
        double price = input.nextDouble();
        input.nextLine();
        while (true) {
            System.out.println("Introdu de la tastatura nivelul de intensitate al antrenamentului:");
            System.out.println("1) Antrenament Usor.");
            System.out.println("2) Antrenament Mediu.");
            System.out.println("3) Antrenament Greu.");
            int intensityLevel = input.nextInt();
            input.nextLine();
            if (intensityLevel == 1) {
                addWorkout(new Workout(name, durationMinutes, Workout.IntensityLevel.EASY, price));
                System.out.println("Antrenamentul Usor a fost adaugat cu succes.");
                break;
            }
            if (intensityLevel == 2) {
                addWorkout(new Workout(name, durationMinutes, Workout.IntensityLevel.MEDIUM, price));
                System.out.println("Antrenamentul Mediu a fost adaugat cu succes.");
                break;
            }
            if (intensityLevel == 3) {
                addWorkout(new Workout(name, durationMinutes, Workout.IntensityLevel.HARD, price));
                System.out.println("Antrenamentul Greu a fost adaugat cu succes.");
                break;
            } else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
        }
    }

    @Override
    public void displayMemberships() {

        if (this.clients.isEmpty()) {
            System.out.println("Nu exista clienti inregistrati.");
            return;
        }
        for (Client client : clients) {
            System.out.println("Abonamentele achizitionate de clientul " + client.getName() + " sunt:");
            for (Membership membership : client.getMemberships()) {
                membership.getMembershipType();
            }
        }
    }

    @Override
    public void displayTrainers() {
        if (this.trainers.isEmpty()) {
            System.out.println("Nu exista antrenori inregistrati.");
            return;
        }
        int indexTrainer = 1;
        for (Trainer trainer : trainers) {
            System.out.print(indexTrainer + ". ");
            indexTrainer++;
            if (trainer instanceof Employee)
                System.out.println("Antrenorul " + trainer.getName() + " cu varsta de " + trainer.getAge() + " ani cu specializarea " + trainer.getSpecialization() + " care reprezinta un " + trainer.getTrainerType() + " avand salariul de " + (((Employee) trainer).getSalary()) + " lei.");
            else if (trainer instanceof Collaborator)
                System.out.println("Antrenorul " + trainer.getName() + " cu varsta de " + trainer.getAge() + " ani cu specializarea " + trainer.getSpecialization() + " care reprezinta un " + trainer.getTrainerType() + " reprezentat de compania " + ((Collaborator) trainer).getCompany());
            if (trainer.getWorkouts().isEmpty())
                System.out.println("Acest antrenor nu preda niciun antrenament.");
            else {
                System.out.println("Antrenamentele predate de acest antrenor sunt:");
                for (Workout workout : trainer.getWorkouts())
                    System.out.println("Antrenamentul " + workout.getName() + " are durata de " + workout.getDurationMinutes() + " minute, cu nivelul de dificultate " + workout.getIntensityLevel() + ", avand pretul de " + workout.getPrice() + " lei.");
            }
        }
    }

    @Override
    public void displayWorkouts() {
        if (this.workouts.isEmpty()) {
            System.out.println("Nu exista antrenamente inregistrate.");
            return;
        }
        int indexWorkout = 1;
        for (Workout workout : workouts) {
            System.out.print(indexWorkout + ". ");
            indexWorkout++;
            System.out.println(workout);
        }
    }

    @Override
    public void displayWorkouts(final String name) {
        int indexWorkout = 1;
        for (Workout workout : workouts)
            if (workout.getName().equals(name) && workout.getTrainer() == null) {
                System.out.print(indexWorkout + ". ");
                indexWorkout++;
                System.out.println("Antrenamentul " + workout.getName() + " are durata de " + workout.getDurationMinutes() + " minute, cu nivelul de dificultate " + workout.getIntensityLevel() + ", avand pretul de " + workout.getPrice() + " lei. ");
            }
    }

    @Override
    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    @Override
    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    @Override
    public ArrayList<Workout> getAvailableWorkoutsByName(final String name) {
        ArrayList<Workout> availableWorkouts = new ArrayList<>();
        for (Workout workout : workouts)
            if (workout.getName().equals(name) && workout.getTrainer() == null)
                availableWorkouts.add(workout);
        return availableWorkouts;
    }

    @Override
    public void displayClients() {
        int clientIndex = 1;
        for (Client client : clients) {
            System.out.print(clientIndex + ". ");
            System.out.println(client);
            clientIndex++;
        }
    }

    @Override
    public void displayClientDetails() {
        if (this.clients.isEmpty()) {
            System.out.println("Nu exista clienti inregistrati.");
            return;
        }
        int index = 1;
        for (Client client : clients) {
            System.out.print(index + ". ");
            index++;
            System.out.println(client);
            if (client.getMemberships().isEmpty())
                System.out.println("Acest client nu are niciun abonament.");
            else {
                System.out.println("Abonamentele achizitionate de acest client sunt:");
                for (Membership membership : client.getMemberships())
                    System.out.println("- " + membership.getMembershipType());
            }
            if (client.getPurchasedWorkoutsCount() == 0)
                System.out.println("Acest client nu a cumparat niciun antrenament.");
            else {
                System.out.println("Antrenamentele cumparate de acest client sunt:");
                for (Workout workout : client.getWorkouts())
                    System.out.println(workout);
            }
        }
    }

    @Override
    public void generateReport() {
        if (workouts.isEmpty()) {
            System.out.println("Nu exista antrenamente inregistrate.");
            return;
        }
        System.out.println("Raport FitZone:");
        for (Workout workout : workouts) {
            boolean trainersAvailable = false;
            System.out.println("Pentru antrenamentul: " + workout.getName());
            for (Trainer trainer : trainers)
                if (trainer.getSpecialization().equals(workout.getName())) {
                    trainersAvailable = true;
                    System.out.println("Antrenorul " + trainer.getName() + " este disponibil sa predea acest antrenament.");
                }
            if (!trainersAvailable)
                System.out.println("Nu exista antrenori disponibili sa predea acest antrenament.");
        }
    }
}
