package org.example;
import java.util.ArrayList;
public class FitZone implements Fitness{

    private ArrayList<Antrenor> antrenori;
    private ArrayList<Abonament> abonamente;

    public FitZone()
    {
        this.abonamente=new ArrayList<>();
        this.antrenori=new ArrayList<>();
    }
    @Override
    public void adaugaAbonament(Abonament abonament) {
        abonamente.add(abonament);
    }
    @Override
    public void angajeazaAntrenor(Antrenor antrenor) {
        antrenori.add(antrenor);
    }

    @Override
    public void afiseazaAbonamente() {
        for(Abonament abonament : abonamente)
            System.out.println("Abonamentul "+abonament.getTip()+" cu pretul: "+abonament.getPret()+" cu durata de: "+abonament.getDurataLuni());
    }
}
