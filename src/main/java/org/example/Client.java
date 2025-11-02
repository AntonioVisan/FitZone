package org.example;
import java.util.ArrayList;
public class Client {
    //client
    private final String nume;
    private final Integer varsta;
    private final ArrayList <Abonament> abonamente=new ArrayList<>();
    private final ArrayList <Antrenament> antrenamente=new ArrayList<>();
    public Client(String name, Integer varsta, Abonament abonament) {
        this.nume = name;
        this.varsta = varsta;
        this.abonamente.add(abonament);
    }

    public String getNume() {
        return nume;
    }

    public ArrayList<Abonament> getAbonamente() {
        return abonamente;
    }

    public ArrayList<Antrenament> getAntrenamente()
    {
        return antrenamente;
    }
    public void adaugaAntrenament(Antrenament antrenament) {
        this.antrenamente.add(antrenament);
    }

    public void adaugaAbonament(Abonament abonament) {
        this.abonamente.add(abonament);
    }
    public void getInfo() {
        System.out.println("Clientul: " + nume + " cu varsta de " + varsta + " de ani. ");
    }
    public int AntrenamenteCumparate()
    {
        return this.antrenamente.size();
    }
}
