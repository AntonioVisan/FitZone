package org.example;
import java.util.ArrayList;
public class Client {
    //client
    private final String nume;
    private final Integer varsta;
    private final ArrayList <Membership> abonamente=new ArrayList<>();
    private final ArrayList <Antrenament> antrenamente=new ArrayList<>();
    public Client(String name, Integer varsta, Membership membership) {
        this.nume = name;
        this.varsta = varsta;
        this.abonamente.add(membership);
    }

    public String getNume() {
        return nume;
    }

    public ArrayList<Membership> getAbonamente() {
        return abonamente;
    }

    public ArrayList<Antrenament> getAntrenamente()
    {
        return antrenamente;
    }
    public void adaugaAntrenament(Antrenament antrenament) {
        this.antrenamente.add(antrenament);
    }

    public void adaugaAbonament(Membership membership) {
        this.abonamente.add(membership);
    }
    public void getInfo() {
        System.out.println("Clientul: " + nume + " cu varsta de " + varsta + " de ani. ");
    }
    public int AntrenamenteCumparate()
    {
        return this.antrenamente.size();
    }
}
