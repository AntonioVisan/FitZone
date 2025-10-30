package org.example;

public class Antrenament {

    public enum NivelIntensitate{
        USOR,
        MEDIU,
        GREU
    };
    private NivelIntensitate intensitate;
    private double pret;

    public Antrenament(NivelIntensitate nivel, double pret) {
        this.intensitate = nivel;
        this.pret = pret;
    }

    public NivelIntensitate getIntensitate() {
        return intensitate;
    }

    public double getPret() {
        return pret;
    }
    
}
