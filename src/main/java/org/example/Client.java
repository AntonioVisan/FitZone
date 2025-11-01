package org.example;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Client {
    private String nume;
    private Integer varsta;
    private ArrayList <Abonament> abonamente=new ArrayList<>();
    private ArrayList <Antrenament> antrenamente=new ArrayList<>();
    public Client(String name, Integer varsta, Abonament abonament) {
        this.nume = name;
        this.varsta = varsta;
        this.abonamente.add(abonament);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public ArrayList<Abonament> getAbonamente() {
        return abonamente;
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
}
