package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class FitZone implements Fitness{
//fitzone
    private final ArrayList<Antrenor> antrenori;
    private final ArrayList<Client> clienti;
    private final ArrayList<Antrenament> antrenamente;
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
    public void insereazaAntrenamente(Antrenament antrenament) {
        antrenamente.add(antrenament);
    }
    @Override
    public void inserareClient(Client client) {
        clienti.add(client);
    }
    @Override
    public void adaugareAntrenor(Scanner input)
    {
        System.out.println("Introdu de la tastatura numele antrenorului: ");
        String nume = input.nextLine();
        System.out.println("Introdu de la tastatura specializarea antrenorului: ");
        String specializare = input.nextLine();
        System.out.println("Introdu de la tastatura varsta antrenorului: ");
        int varsta = input.nextInt();
        input.nextLine(); //consumare enter
        while (true) {
            System.out.println("Ce antrenor doresti sa angajezi?");
            System.out.println("1) Angajat permanent");
            System.out.println("2) Colaborator extern");
            int optiune = input.nextInt();
            input.nextLine(); //consumare enter
            if (optiune == 1) {
                System.out.println("Introdu de la tastatura salariul angajatului:");
                double salariu = input.nextDouble();
                input.nextLine(); //consumare enter
                angajeazaAntrenor(new Angajat(nume, specializare, varsta, salariu));
                System.out.println("Antrenor angajat cu succes.");
                break;
            }
            if (optiune == 2) {
                System.out.println("Introdu de la tastatura compania colaboratorului:");
                String companie = input.nextLine();
                angajeazaAntrenor(new Colaborator(nume, specializare, varsta, companie));
                System.out.println("Colaborator angajat cu succes.");
                break;
            }
            else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
        }
    }
    @Override
    public Client selecteazaClient(Scanner input, String mesaj)
    {
        if (getClienti().isEmpty()) {
            System.out.println("Nu exista clienti inregistrati.");
            return null;
        }
        System.out.println(mesaj);
        afiseazaClienti();
        int indexClient=input.nextInt();
        input.nextLine(); //consumare enter
        if(!(indexClient>=1 && indexClient<=getClienti().size()))
        {
            System.out.println("Index invalid pentru client. Mai incearca o data.");
            return null;
        }
        return getClienti().get(indexClient-1);
    }
    @Override
    public void adaugareClient(Scanner input)
    {
        System.out.println("Introdu de la tastatura numele clientului: ");
        String nume = input.nextLine();
        System.out.println("Introdu de la tastatura varsta clientului: ");
        int varsta = input.nextInt();
        input.nextLine(); //consumare enter
        System.out.println("Introdu de la tastatura pretul abonamentului pentru client: ");
        double pret = input.nextDouble();
        input.nextLine(); //consumare enter
        System.out.println("Introdu de la tastatura durata in luni a abonamentului pentru client: ");
        int durata = input.nextInt();
        input.nextLine(); //consumare enter
        while (true) {
            System.out.println("Introdu de la tastatura tipul abonamentului dorit pentru client: ");
            System.out.println("1) Abonament Standard.");
            System.out.println("2) Abonament Premium.");
            int optiune = input.nextInt();
            input.nextLine(); //consumare enter
            if (optiune == 1) {
                inserareClient(new Client(nume, varsta, new Standard(pret, durata)));
                System.out.println("Clientul si abonamentul Standard au fost adaugati cu succes.");
                break;
            }
            if (optiune == 2) {
                inserareClient(new Client(nume, varsta, new Premium(pret, durata)));
                System.out.println("Clientul si abonamentul Premium au fost adaugati cu succes.");
                break;
            }
            else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
        }
    }
    @Override
    public void adaugareAbonamentForClient(Scanner input)
    {
        Client client = selecteazaClient(input, "Selecteaza index-ul clientului caruia doresti sa ii adaugi un abonament: ");
        if(client==null)
            return ;
        System.out.println("Introdu de la tastatura pretul abonamentului: ");
        double pret = input.nextDouble();
        input.nextLine(); //consumare enter
        System.out.println("Introdu de la tastatura durata in luni a abonamentului: ");
        int durata = input.nextInt();
        input.nextLine(); //consumare enter
        while (true) {
            System.out.println("Introdu de la tastatura tipul abonamentului dorit: ");
            System.out.println("1) Abonament Standard.");
            System.out.println("2) Abonament Premium.");
            int optiune = input.nextInt();
            input.nextLine(); //consumare enter
            if (optiune == 1) {
                Abonament standard = new Standard(pret, durata);
                standard.aplicaReducere(); //verifica daca se poate aplica reducerea
                //daca abonamentul are o durata de minim 12 luni, se aplica o reducere de 20% la pret
                client.adaugaAbonament(standard);
                System.out.println("Abonament Standard adaugat cu succes.");
                break;
            }
            if (optiune == 2) {
                Abonament premium = new Premium(pret, durata);
                premium.aplicaReducere(); //verifica daca se poate aplica reducerea
                //daca abonamentul are o durata de minim 12 luni, se aplica o reducere de 20% la pret
                client.adaugaAbonament(premium);
                System.out.println("Abonament Premium adaugat cu succes.");
                break;
            } else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
        }
    }
    @Override
    public void adaugareAntrenamentForClient(Scanner input)
    {
        Client client = selecteazaClient(input,"Selecteaza index-ul clientului caruia doresti sa ii adaugi un antrenament: ");
        if(client==null)
            return ;
        Antrenament antrenament = selecteazaAntrenament(input, client);
        if(antrenament==null)
            return ;
        if (client.AntrenamenteCumparate() % 3 == 0 && client.AntrenamenteCumparate()>0) //daca are multiplu de 3 antrenamente cumparate, se aplica o reducere de 10% la pret
            antrenament.aplicaReducere();
        client.adaugaAntrenament(antrenament);
        System.out.println("Antrenamentul a fost adaugat cu succes clientului "+client.getNume()+".");
    }
    @Override
    public Antrenor selecteazaAntrenor(Scanner input, String mesaj)
    {
        if (getAntrenori().isEmpty()) {
            System.out.println("Nu exista antrenori inregistrati.");
            return null;
        }
        System.out.println(mesaj);
        afiseazaAntrenori();
        int indexAntrenor = input.nextInt();
        input.nextLine(); //consumare enter
        if (!(indexAntrenor >= 1 && indexAntrenor <= getAntrenori().size())) {
            System.out.println("Index invalid pentru antrenor. Mai incearca o data.");
            return null;
        }
        return getAntrenori().get(indexAntrenor - 1);
    }
    @Override
    public Antrenament selecteazaAntrenament(Scanner input, Client client)
    {
        System.out.println("Selecteaza index-ul antrenamentului pe care doresti sa-l atribui clientului " + client.getNume() + ": ");
        afiseazaAntrenamente();
        int indexAntrenament = input.nextInt();
        input.nextLine(); //consumare enter
        if (!(indexAntrenament >= 1 && indexAntrenament <= getAntrenamente().size())) {
            System.out.println("Index invalid pentru antrenament. Mai incearca o data.");
            return null;
        }
        return getAntrenamente().get(indexAntrenament - 1);
    }
    @Override
    public Antrenament selecteazaAntrenament(Scanner input, Antrenor antrenor)
    {
        ArrayList<Antrenament> antrenamenteDisponibile = getAntrenamenteDisponibileDupaDenumire(antrenor.getSpecializare());
        if (antrenamenteDisponibile.isEmpty()) {
            System.out.println("Nu exista antrenamente inregistrate.");
            return null;
        }

        System.out.println("Selecteaza index-ul antrenamentului pe care doresti sa-l atribui antrenorului " + antrenor.getNume() + ": ");
        afiseazaAntrenamente(antrenor.getSpecializare());
        int indexAntrenament = input.nextInt();
        input.nextLine(); //consumare enter
        if (!(indexAntrenament >= 1 && indexAntrenament <= antrenamenteDisponibile.size())) {
            System.out.println("Index invalid pentru antrenament. Mai incearca o data.");
            return null;
        }
        return antrenamenteDisponibile.get(indexAntrenament - 1);
    }
    @Override
    public void adaugareAntrenamentForAntrenor(Scanner input)
    {
        Antrenor antrenor = selecteazaAntrenor(input, "Selecteaza index-ul antrenorului caruia doresti sa ii adaugi un antrenament: ");
        if(antrenor==null)
            return ;
        Antrenament antrenament = selecteazaAntrenament(input, antrenor);
        if(antrenament==null)
            return ;
        antrenament.setAntrenor(antrenor);
        antrenor.adaugaAntrenament(antrenament);
        System.out.println("Antrenamentul a fost atribuit cu succes antrenorului "+antrenor.getNume()+".");
    }
    @Override
    public void adaugareAntrenament(Scanner input)
    {
        System.out.println("Introdu de la tastatura denumirea antrenamentului: ");
        String denumire = input.nextLine();
        System.out.println("Introdu de la tastatura durata antrenamentului in minute: ");
        int durata = input.nextInt();
        input.nextLine(); //consumare enter
        System.out.println("Introdu de la tastatura pretul antrenamentului: ");
        double pret = input.nextDouble();
        input.nextLine(); //consumare enter
        while (true) {
            System.out.println("Introdu de la tastatura nivelul de intensitate al antrenamentului:");
            System.out.println("1) Antrenament Usor.");
            System.out.println("2) Antrenament Mediu.");
            System.out.println("3) Antrenament Greu.");
            int nivelIntensitate = input.nextInt();
            input.nextLine(); //consumare enter
            if (nivelIntensitate == 1) {
                insereazaAntrenamente(new Antrenament(denumire, durata, Antrenament.NivelIntensitate.USOR, pret));
                System.out.println("Antrenamentul Usor a fost adaugat cu succes.");
                break;
            }
            if (nivelIntensitate == 2) {
                insereazaAntrenamente(new Antrenament(denumire, durata, Antrenament.NivelIntensitate.MEDIU, pret));
                System.out.println("Antrenamentul Mediu a fost adaugat cu succes.");
                break;
            }
            if (nivelIntensitate == 3) {
                insereazaAntrenamente(new Antrenament(denumire, durata, Antrenament.NivelIntensitate.GREU, pret));
                System.out.println("Antrenamentul Greu a fost adaugat cu succes.");
                break;
            } else System.out.println("Valoare incorecta. Mai introdu o data o optiune.");
        }
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
            antrenament.getInfo();
        }
    }

    @Override
    public void afiseazaAntrenamente(String denumire) {
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
    public void afiseazaClientiDetaliat()
    {
        if(this.clienti.isEmpty())
        {
            System.out.println("Nu exista clienti inregistrati.");
            return;
        }
        Integer index=1;
        for(Client client : clienti)
        {
            System.out.print(index+". ");
            index++;
            client.getInfo();
            if(client.getAbonamente().isEmpty())
                System.out.println("Acest client nu are niciun abonament.");
            else
            {
                System.out.println("Abonamentele achizitionate de acest client sunt:");
                for (Abonament abonament : client.getAbonamente())
                    abonament.getInfo();
            }
            if(client.AntrenamenteCumparate()==0)
                System.out.println("Acest client nu a cumparat niciun antrenament.");
            else
            {
                System.out.println("Antrenamentele cumparate de acest client sunt:");
                for(Antrenament antrenament : client.getAntrenamente())
                    antrenament.getInfo();
            }
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
            boolean existaAntrenori=false;
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
