package org.example;

public class Antrenament {

    public enum NivelIntensitate{
        USOR,
        MEDIU,
        GREU
    };
    private String denumire;
    private Integer durata;
    private NivelIntensitate intensitate;
    private double pret;
    private Antrenor antrenor=null;

    public Antrenament(String denumire, Integer durata, NivelIntensitate nivel, double pret) {
        this.denumire=denumire;
        this.durata=durata;
        this.intensitate = nivel;
        this.pret = pret;
    }

    public NivelIntensitate getIntensitate() {
        return intensitate;
    }

    public double getPret() {
        return pret;
    }

    public String getDenumire() {
        return denumire;
    }

    public Integer getDurata() {
        return durata;
    }

    public Antrenor getAntrenor() {
        return antrenor;
    }

    public void setAntrenor(Antrenor antrenor) {
        this.antrenor = antrenor;
    }
}
