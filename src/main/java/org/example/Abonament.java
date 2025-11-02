package org.example;

public abstract class Abonament {

    private double pret;
    private final int durataLuni;

    public Abonament(double pret, int durataLuni)
    {
        this.pret = pret;
        this.durataLuni = durataLuni;
    }

    public void getInfo()
    {
        System.out.println("Abonamentul "+this.getTip()+" cu pretul "+this.getPret()+" de lei cu durata de "+this.getDurataLuni()+" luni.");
    }
    public abstract String getTip();

    public double getPret() {
        return pret;
    }

    public int getDurataLuni() {
        return durataLuni;
    }

    public void aplicaReducere()
    {
        if (this.durataLuni >= 12) //daca abonamentul are o durata de minim 12 luni, se aplica o reducere de 20% la pret
        {
            System.out.println("A fost aplicata o reducere de 20% la pretul abonamentului.");
            System.out.println("Initial, pretul era: "+this.pret);
            this.pret = this.pret * 0.8;
            System.out.println("Acum, pretul este: "+this.pret);
        }
    }
}
