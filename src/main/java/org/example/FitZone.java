package org.example;
import java.util.ArrayList;
public class FitZone implements Fitness{

    private ArrayList<Antrenor> antrenori;
    private ArrayList<Client> clienti;
    private ArrayList<Antrenament> antrenamente;
    public FitZone()
    {
        this.antrenori=new ArrayList<>();
        this.clienti=new ArrayList<>();
        this.antrenamente=new ArrayList<>();
    }
    @Override
    public void angajeazaAntrenor(Antrenor antrenor) {
        antrenori.add(antrenor);
    }

    @Override
    public void adaugaAntrenamente(Antrenament antrenament) {
        antrenamente.add(antrenament);
    }
    @Override
    public void adaugaClient(Client client) {
        clienti.add(client);
    }
    @Override
    public void afiseazaAbonamente() {

        if (this.clienti.isEmpty()) {
            System.out.println("Nu exista clienti inregistrati.");
            return;
        }
        for (Client client : clienti) {
            System.out.println("Abonamentele achizitionate de clientul " + client.getNume() + " sunt:");
            for (Abonament abonament : client.getAbonamente()) {
                abonament.getInfo();
            }
        }
    }

    @Override
    public void afiseazaAntrenori() {
        if (this.antrenori.isEmpty()) {
            System.out.println("Nu exista antrenori inregistrati.");
            return;
        }
        Integer indexAntrenor = 1;
        for (Antrenor antrenor : antrenori) {
            System.out.print(indexAntrenor + ". ");
            indexAntrenor++;
            if (antrenor instanceof Angajat)
                System.out.println("Antrenorul " + antrenor.getNume() + " cu varsta de " + antrenor.getAge() + " ani cu specializarea " + antrenor.getSpecializare() + " care reprezinta un " + antrenor.getTip() + " avand salariul de " + (((Angajat) antrenor).getSalariu()) + " lei.");
            else if (antrenor instanceof Colaborator)
                System.out.println("Antrenorul " + antrenor.getNume() + " cu varsta de " + antrenor.getAge() + " ani cu specializarea " + antrenor.getSpecializare() + " care reprezinta un " + antrenor.getTip() + " reprezentat de compania " + ((Colaborator) antrenor).getCompanie());
            if (antrenor.getAntrenamente().isEmpty())
                System.out.println("Acest antrenor nu preda niciun antrenament.");
            else {
                System.out.println("Antrenamentele predate de acest antrenor sunt:");
                for (Antrenament antrenament : antrenor.getAntrenamente())
                    System.out.println("Antrenamentul " + antrenament.getDenumire() + " are durata de " + antrenament.getDurata() + " minute, cu nivelul de dificultate " + antrenament.getIntensitate() + ", avand pretul de " + antrenament.getPret() + " lei.");
            }
        }
    }
    @Override
    public void afiseazaAntrenamente() {
        if (this.antrenamente.isEmpty()) {
            System.out.println("Nu exista antrenamente inregistrate.");
            return;
        }
        Integer indexAntrenament = 1;
        for (Antrenament antrenament : antrenamente) {
            System.out.print(indexAntrenament + ". ");
            indexAntrenament++;
            if(antrenament.getAntrenor()==null)
                System.out.println("Antrenamentul " + antrenament.getDenumire() + " are durata de " + antrenament.getDurata() + " minute, cu nivelul de dificultate " + antrenament.getIntensitate() + ", avand pretul de " + antrenament.getPret() + " lei. Acest antrenament nu este predat de niciun antrenor.");
            else
                System.out.println("Antrenamentul " + antrenament.getDenumire() + " are durata de " + antrenament.getDurata() + " minute, cu nivelul de dificultate " + antrenament.getIntensitate() + ", avand pretul de " + antrenament.getPret() + " lei. Acest antrenament este predat de "+antrenament.getAntrenor().getNume()+".");
        }
    }

    @Override
    public void afiseazaAntrenamenteDisponibileDupaDenumire(String denumire) {
        Integer indexAntrenament = 1;
        for (Antrenament antrenament : antrenamente)
            if (antrenament.getDenumire().equals(denumire) && antrenament.getAntrenor() == null) {
                System.out.print(indexAntrenament + ". ");
                indexAntrenament++;
                System.out.println("Antrenamentul " + antrenament.getDenumire() + " are durata de " + antrenament.getDurata() + " minute, cu nivelul de dificultate " + antrenament.getIntensitate() + ", avand pretul de " + antrenament.getPret() + " lei. ");
            }
    }
    @Override
    public ArrayList<Antrenament> getAntrenamente()
    {
        return antrenamente;
    }
    @Override
    public ArrayList<Client> getClienti()
    {
        return clienti;
    }
    @Override
    public ArrayList<Antrenor> getAntrenori()
    {
        return antrenori;
    }
    @Override
    public ArrayList<Antrenament> getAntrenamenteDisponibileDupaDenumire(String denumire)
    {
        ArrayList<Antrenament> antrenamenteDisponibile=new ArrayList<>();
        for(Antrenament antrenament : antrenamente)
            if(antrenament.getDenumire().equals(denumire) && antrenament.getAntrenor()==null)
                antrenamenteDisponibile.add(antrenament);
        return antrenamenteDisponibile;
    }
    @Override
    public void afiseazaClienti()
    {
        Integer indexClient=1;
        for(Client client : clienti)
        {
            System.out.print(indexClient+". ");
            client.getInfo();
            indexClient++;
        }
    }
    @Override
    public void generareRaport()
    {
        if(antrenamente.isEmpty())
        {
            System.out.println("Nu exista antrenamente inregistrate.");
            return;
        }
        System.out.println("Raport FitZone:");
        for(Antrenament antrenament : antrenamente)
        {
            Boolean existaAntrenori=false;
            System.out.println("Pentru antrenamentul: "+antrenament.getDenumire());
            for(Antrenor antrenor : antrenori)
                if(antrenor.getSpecializare().equals(antrenament.getDenumire()))
                {
                    existaAntrenori=true;
                    System.out.println("Antrenorul "+antrenor.getNume()+" este disponibil sa predea acest antrenament.");
                }
            if(!existaAntrenori)
                System.out.println("Nu exista antrenori disponibili sa predea acest antrenament.");
        }
    }
}
