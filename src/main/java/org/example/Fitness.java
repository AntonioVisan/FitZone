package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public interface Fitness {
    //fitness
    void angajeazaAntrenor(Trainer antrenor);
    void insereazaAntrenamente(Workout workout);
    void inserareClient(Client client);
    void adaugareAntrenor(Scanner input);
    void adaugareClient(Scanner input);
    void adaugareAbonamentForClient(Scanner input);
    void adaugareAntrenament(Scanner input);
    void adaugareAntrenamentForAntrenor(Scanner input);
    void adaugareAntrenamentForClient(Scanner input);
    Client selecteazaClient(Scanner input, String mesaj);
    Trainer selecteazaAntrenor(Scanner input, String mesaj);
    Workout selecteazaAntrenament(Scanner input, Client client);
    Workout selecteazaAntrenament(Scanner input, Trainer antrenor);
    void afiseazaAbonamente();
    void afiseazaAntrenori();
    void afiseazaAntrenamente();
    void afiseazaAntrenamente(String denumire);
    ArrayList<Client> getClienti();
    ArrayList<Trainer> getAntrenori();
    ArrayList<Workout> getAntrenamente();
    ArrayList<Workout> getAntrenamenteDisponibileDupaDenumire(String denumire);
    void afiseazaClienti();
    void afiseazaClientiDetaliat();
    void generareRaport();

}
