package org.example;
import java.util.ArrayList;
public interface Fitness {
    void angajeazaAntrenor(Antrenor antrenor);
    void adaugaAntrenamente(Antrenament antrenament);
    void adaugaClient(Client client);
    void afiseazaAbonamente();
    void afiseazaAntrenori();
    void afiseazaAntrenamente();
    void afiseazaAntrenamenteDisponibileDupaDenumire(String denumire);
    ArrayList<Client> getClienti();
    ArrayList<Antrenor> getAntrenori();
    ArrayList<Antrenament> getAntrenamente();
    ArrayList<Antrenament> getAntrenamenteDisponibileDupaDenumire(String denumire);
    void afiseazaClienti();
    void generareRaport();

}
