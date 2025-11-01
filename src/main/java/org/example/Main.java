package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FitZone sala = new FitZone();
        System.out.println("Introduce de la tastatura o optiune: ");
        System.out.println("1) Adaugare antrenor pentru sala de fitness FitZone+");
        System.out.println("2) Afisarea abonamentelor: ");
        System.out.println("3) Generare raport: ");
        int optiune = input.nextInt();
        input.nextLine();
        System.out.println("Optiune: "+optiune);
        while (optiune >= 1 && optiune <= 3) {
            switch (optiune) {
                case 1:
                    System.out.println("Introdu de la tastatura numele antrenorului: ");
                    String nume = input.nextLine();
                    System.out.println("Introdu de la tastatura specializarea antrenorului: ");
                    String specializare = input.nextLine();
                    System.out.println("Introdu de la tastatura varsta antrenorului: ");
                    Integer age = input.nextInt();
                    System.out.println("Ce antrenor doresti sa angajezi?");
                    System.out.println("1) Angajat permanent");
                    System.out.println("2) Colaborator extern");
                    int optiuneAngajat = input.nextInt();
                    while (optiuneAngajat >=1  && optiuneAngajat <= 2) {
                        switch (optiuneAngajat) {
                            case 1:
                                System.out.println("Introdu de la tastatura salariul angajatului:");
                                double salariu = input.nextDouble();
                                sala.angajeazaAntrenor(new Angajat(nume, specializare, age, salariu));
                                break;
                            case 2:
                                System.out.println("Introdu de la tastatura compania colaboratorului:");
                                String companie = input.nextLine();
                                sala.angajeazaAntrenor(new Colaborator(nume, specializare, age, companie));
                                break;
                            default:
                                System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
                        }
                        optiuneAngajat = input.nextInt();
                    }
                    break;
                case 2:
                    sala.afiseazaAbonamente();
                    break;
                case 3:
                    //generare raport
                    break;
                default:
                    System.out.println("Valoare incorecta. Mai citeste o data o optiune.");
            }
            optiune = input.nextInt();
        }
    }
}