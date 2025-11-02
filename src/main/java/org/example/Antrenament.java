package org.example;

public class Antrenament {

    public enum NivelIntensitate{
        USOR,
        MEDIU,
        GREU
    }
    private final String denumire;
    private final Integer durata;
    private final NivelIntensitate intensitate;
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

    public void getInfo()
    {
        if(getAntrenor()==null)
            System.out.println("Antrenamentul " + getDenumire() + " are durata de " + getDurata() + " minute, cu nivelul de dificultate " + getIntensitate() + ", avand pretul de " + getPret() + " lei. Acest antrenament nu este predat de niciun antrenor.");
        else
            System.out.println("Antrenamentul " + getDenumire() + " are durata de " + getDurata() + " minute, cu nivelul de dificultate " + getIntensitate() + ", avand pretul de " + getPret() + " lei. Acest antrenament este predat de "+ getAntrenor().getNume()+".");
    }
    public void aplicaReducere()
    {
        System.out.println("A fost aplicata o reducere de 10% la pretul antrenamentului pentru cumpararea a 3 antrenamente.");
        System.out.println("Initial, pretul era: "+this.pret);
        pret=pret*0.9; //se aplica reducere de 10% la cate 3 abonamente cumparate
        System.out.println("Acum, pretul este: "+this.pret);
    }
}
