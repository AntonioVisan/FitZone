package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //main
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FitZone sala = new FitZone();
        while(true)
        {
            System.out.println("Introduce de la tastatura o optiune: ");
            System.out.println("1) Adaugare antrenor pentru sala de fitness FitZone+.");
            System.out.println("2) Adaugare client pentru sala de fitness FitZone+.");
            System.out.println("3) Adaugare abonament pentru un client existent.");
            System.out.println("4) Adaugare antrenament pentru sala de fitness FitZone+.");
            System.out.println("5) Adaugare antrenament pentru un antrenor existent.");
            System.out.println("6) Adaugare antrenament pentru un client existent.");
            System.out.println("7) Afisarea abonamentelor achizitionate de clienti. ");
            System.out.println("8) Afisarea antrenorilor. ");
            System.out.println("9) Afisarea antrenamentelor. ");
            System.out.println("10) Afisarea clientilor.");
            System.out.println("11) Generare raport. ");
            System.out.println("12) Inchidere aplicatie.");
            int optiune = input.nextInt();
            input.nextLine(); //consumare enter
            if (optiune == 12)
            {
                System.out.println("Aplicatia se inchide. La revedere!");
                break; //iesire aplicatie
            }
            switch (optiune) {
                case 1:
                    sala.addTrainer(input);
                    break;
                case 2:
                    sala.addClient(input);
                    break;
                case 3:
                    sala.addMembershipForClient(input);
                    break;
                case 4:
                    sala.addWorkout(input);
                    break;
                case 5:
                    sala.addWorkoutForTrainer(input);
                    break;
                case 6:
                    sala.addWorkoutForClient(input);
                    break;
                case 7:
                    System.out.println("Afisarea abonamentelor: ");
                    sala.displayMemberships();
                    break;
                case 8:
                    System.out.println("Afisarea antrenorilor: ");
                    sala.displayTrainers();
                    break;
                case 9:
                    System.out.println("Afisarea antrenamentelor: ");
                    sala.displayWorkouts();
                    break;
                case 10:
                    System.out.println("Afisarea clientilor: ");
                    sala.displayClientDetails();
                    break;
                case 11:
                    sala.generateReport();
                    break;
                default:
                    System.out.println("Valoare incorecta. Mai citeste o data o optiune.");
                }
        }
        input.close();
    }
}