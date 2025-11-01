package org.example;

import java.util.Scanner;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FitZone sala = new FitZone();
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
        System.out.println("10) Generare raport. ");
        System.out.println("11) Inchidere aplicatie.");
        int optiune = input.nextInt();
        input.nextLine(); //consumare enter
        while (true)
        {
            if(optiune==11) break; //iesire aplicatie
            switch (optiune) {
                case 1:
                    System.out.println("Introdu de la tastatura numele antrenorului: ");
                    String nume = input.nextLine();
                    System.out.println("Introdu de la tastatura specializarea antrenorului: ");
                    String specializare = input.nextLine();
                    System.out.println("Introdu de la tastatura varsta antrenorului: ");
                    Integer age = input.nextInt();
                    input.nextLine(); //consumare enter
                    while (true) {
                        System.out.println("Ce antrenor doresti sa angajezi?");
                        System.out.println("1) Angajat permanent");
                        System.out.println("2) Colaborator extern");
                        int optiuneAngajat = input.nextInt();
                        input.nextLine(); //consumare enter
                        if (optiuneAngajat == 1) {
                            System.out.println("Introdu de la tastatura salariul angajatului:");
                            double salariu = input.nextDouble();
                            input.nextLine(); //consumare enter
                            sala.angajeazaAntrenor(new Angajat(nume, specializare, age, salariu));
                            System.out.println("Antrenor angajat cu succes.");
                            break;
                        }
                        if (optiuneAngajat == 2) {
                            System.out.println("Introdu de la tastatura compania colaboratorului:");
                            String companie = input.nextLine();
                            sala.angajeazaAntrenor(new Colaborator(nume, specializare, age, companie));
                            System.out.println("Colaborator angajat cu succes.");
                            break;
                        } else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
                    }
                    break;
                case 2:
                    System.out.println("Introdu de la tastatura numele clientului: ");
                    String numeClient = input.nextLine();
                    System.out.println("Introdu de la tastatura varsta clientului: ");
                    int varstaClient = input.nextInt();
                    input.nextLine(); //consumare enter
                    System.out.println("Introdu de la tastatura pretul abonamentului pentru client: ");
                    double pret = input.nextDouble();
                    input.nextLine(); //consumare enter
                    System.out.println("Introdu de la tastatura durata in luni a abonamentului pentru client: ");
                    int durata = input.nextInt();
                    input.nextLine(); //consumare enter
                    while (true) {
                        System.out.println("Introdu de la tastatura tipul abonamentului dorit pentru client: ");
                        System.out.println("1) Abonament Standard.");
                        System.out.println("2) Abonament Premium.");
                        int optiuneAbonament = input.nextInt();
                        input.nextLine(); //consumare enter
                        if (optiuneAbonament == 1) {
                            sala.adaugaClient(new Client(numeClient, varstaClient, new Standard(pret, durata)));
                            System.out.println("Abonament Standard adaugat cu succes pentru client.");
                            break;
                        }
                        if (optiuneAbonament == 2) {
                            sala.adaugaClient(new Client(numeClient, varstaClient, new Premium(pret, durata)));
                            System.out.println("Abonament Premium adaugat cu succes.");
                            break;
                        } else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
                    }
                    break;
                case 3:
                    if (sala.getClienti().isEmpty()) {
                        System.out.println("Nu exista clienti inregistrati.");
                        break;
                    }
                    System.out.println("Selecteaza index-ul clientului caruia doresti sa ii adaugi un abonament: ");
                    sala.afiseazaClienti();
                    int indexClient = input.nextInt();
                    input.nextLine(); //consumare enter
                    if (!(indexClient >= 1 && indexClient <= sala.getClienti().size())) {
                        System.out.println("Index invalid.");
                        break;
                    }
                    Client clientSelectat = sala.getClienti().get(indexClient - 1);
                    System.out.println("Introdu de la tastatura pretul abonamentului: ");
                    double pretAbonament = input.nextDouble();
                    input.nextLine(); //consumare enter
                    System.out.println("Introdu de la tastatura durata in luni a abonamentului: ");
                    int durataAbonament = input.nextInt();
                    input.nextLine(); //consumare enter
                    while (true) {
                        System.out.println("Introdu de la tastatura tipul abonamentului dorit: ");
                        System.out.println("1) Abonament Standard.");
                        System.out.println("2) Abonament Premium.");
                        int optiuneAbonament = input.nextInt();
                        input.nextLine(); //consumare enter
                        if (optiuneAbonament == 1) {
                            clientSelectat.adaugaAbonament(new Standard(pretAbonament, durataAbonament));
                            System.out.println("Abonament Standard adaugat cu succes.");
                            break;
                        }
                        if (optiuneAbonament == 2) {
                            clientSelectat.adaugaAbonament(new Premium(pretAbonament, durataAbonament));
                            System.out.println("Abonament Premium adaugat cu succes.");
                            break;
                        } else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
                    }
                    break;
                case 4:
                    System.out.println("Introdu de la tastatura denumirea antrenamentului: ");
                    String denumireAntrenament = input.nextLine();
                    System.out.println("Introdu de la tastatura durata antrenamentului in minute: ");
                    int durataAntrenament = input.nextInt();
                    input.nextLine(); //consumare enter
                    System.out.println("Introdu de la tastatura pretul antrenamentului: ");
                    double pretAntrenament = input.nextDouble();
                    input.nextLine(); //consumare enter
                    while (true) {
                        System.out.println("Introdu de la tastatura nivelul de intensitate al antrenamentului:");
                        System.out.println("1) Antrenament Usor.");
                        System.out.println("2) Antrenament Mediu.");
                        System.out.println("3) Antrenament Greu.");
                        int nivelIntensitate = input.nextInt();
                        input.nextLine(); //consumare enter
                        if (nivelIntensitate == 1)
                        {
                            sala.adaugaAntrenamente(new Antrenament(denumireAntrenament, durataAntrenament, Antrenament.NivelIntensitate.USOR, pretAntrenament));
                            System.out.println("Antrenamentul Usor a fost adaugat cu succes.");
                            break;
                        }
                        if (nivelIntensitate == 2)
                        {
                            sala.adaugaAntrenamente(new Antrenament(denumireAntrenament, durataAntrenament, Antrenament.NivelIntensitate.MEDIU, pretAntrenament));
                            System.out.println("Antrenamentul Mediu a fost adaugat cu succes.");
                            break;
                        }
                        if (nivelIntensitate == 3)
                        {
                            sala.adaugaAntrenamente(new Antrenament(denumireAntrenament, durataAntrenament, Antrenament.NivelIntensitate.GREU, pretAntrenament));
                            System.out.println("Antrenamentul Greu a fost adaugat cu succes.");
                            break;
                        }
                        else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
                    }
                    break;
                case 5:
                    if (sala.getAntrenori().isEmpty()) {
                        System.out.println("Nu exista antrenori inregistrati.");
                        break;
                    }
                    System.out.println("Selecteaza index-ul antrenorului caruia doresti sa ii adaugi un antrenament: ");
                    sala.afiseazaAntrenori();
                    int indexAntrenor = input.nextInt();
                    input.nextLine(); //consumare enter
                    if (!(indexAntrenor >= 1 && indexAntrenor <= sala.getAntrenori().size())) {
                        System.out.println("Index invalid.");
                        break;
                    }
                    Antrenor antrenorSelectat = sala.getAntrenori().get(indexAntrenor - 1);
                    String specializareAntrenor = antrenorSelectat.getSpecializare();
                    ArrayList<Antrenament> antrenamenteDisponibile = sala.getAntrenamenteDisponibileDupaDenumire(specializareAntrenor);
                    if (antrenamenteDisponibile.isEmpty()) {
                        System.out.println("Nu exista antrenamente inregistrate.");
                        break;
                    }
                    System.out.println("Selecteaza index-ul antrenamentului pe care doresti sa-l atribui antrenorului " + antrenorSelectat.getNume() + ": ");
                    sala.afiseazaAntrenamenteDisponibileDupaDenumire(specializareAntrenor);
                    int indexAntrenament = input.nextInt();
                    input.nextLine(); //consumare enter
                    if (!(indexAntrenament >= 1 && indexAntrenament <= antrenamenteDisponibile.size())) {
                        System.out.println("Index invalid.");
                        break;
                    }
                    Antrenament antrenamentSelectat = antrenamenteDisponibile.get(indexAntrenament - 1);
                    antrenamentSelectat.setAntrenor(antrenorSelectat);
                    antrenorSelectat.adaugaAntrenament(antrenamentSelectat);
                    break;
                case 6:
                    if (sala.getClienti().isEmpty()) {
                        System.out.println("Nu exista clienti inregistrati.");
                        break;
                    }
                    System.out.println("Selecteaza index-ul clientului caruia doresti sa ii adaugi un antrenament: ");
                    sala.afiseazaClienti();
                    int indexClientForAntrenament = input.nextInt();
                    input.nextLine(); //consumare enter
                    if (!(indexClientForAntrenament >= 1 && indexClientForAntrenament <= sala.getClienti().size())) {
                        System.out.println("Index invalid.");
                        break;
                    }
                    Client clientSelectatForAntrenament = sala.getClienti().get(indexClientForAntrenament - 1);
                    System.out.println("Selecteaza index-ul antrenamentului pe care doresti sa-l atribui clientului " + clientSelectatForAntrenament.getNume() + ": ");
                    sala.afiseazaAntrenamente();
                    int indexAntrenamentForClient = input.nextInt();
                    input.nextLine(); //consumare enter
                    if (!(indexAntrenamentForClient >= 1 && indexAntrenamentForClient <= sala.getAntrenamente().size()))
                        System.out.println("Index invalid.");
                    Antrenament antrenament = sala.getAntrenamente().get(indexAntrenamentForClient  - 1);
                    clientSelectatForAntrenament.adaugaAntrenament(antrenament);
                    break;

                case 7:
                    System.out.println("Afisarea abonamentelor: ");
                    sala.afiseazaAbonamente();
                    break;
                case 8:
                    System.out.println("Afisarea antrenorilor: ");
                    sala.afiseazaAntrenori();
                    break;
                case 9:
                    System.out.println("Afisarea antrenamentelor: ");
                    sala.afiseazaAntrenamente();
                    break;
                case 10:
                    sala.generareRaport();
                    break;
                default:
                    System.out.println("Valoare incorecta. Mai citeste o data o optiune.");
            }

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
            System.out.println("10) Generare raport. ");
            System.out.println("11) Inchidere aplicatie.");

            optiune = input.nextInt();
            input.nextLine(); //consumare enter
        }
        input.close();
    }
}