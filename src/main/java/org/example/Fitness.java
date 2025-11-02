package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public interface Fitness {
    void angajeazaAntrenor(Antrenor antrenor);
    void insereazaAntrenamente(Antrenament antrenament);
    void inserareClient(Client client);
    void adaugareAntrenor(Scanner input);
    void adaugareClient(Scanner input);
    void adaugareAbonamentForClient(Scanner input);
    void adaugareAntrenament(Scanner input);
    void adaugareAntrenamentForAntrenor(Scanner input);
    void adaugareAntrenamentForClient(Scanner input);
    Client selecteazaClient(Scanner input, String mesaj);
    Antrenor selecteazaAntrenor(Scanner input, String mesaj);
    Antrenament selecteazaAntrenament(Scanner input, Client client);
    Antrenament selecteazaAntrenament(Scanner input, Antrenor antrenor);
    void afiseazaAbonamente();
    void afiseazaAntrenori();
    void afiseazaAntrenamente();
    void afiseazaAntrenamente(String denumire);
    ArrayList<Client> getClienti();
    ArrayList<Antrenor> getAntrenori();
    ArrayList<Antrenament> getAntrenamente();
    ArrayList<Antrenament> getAntrenamenteDisponibileDupaDenumire(String denumire);
    void afiseazaClienti();
    void afiseazaClientiDetaliat();
    void generareRaport();

}
