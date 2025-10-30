package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Antrenor a1 = new Antrenor("Ion Popescu", "Yoga", 35, Antrenor.TipAngajat.ANGAJAT_PERMANENT);
        Abonament abonament1 = new Standard("Standard", 100, 6);
        Antrenament antrenament1 = new Antrenament(Antrenament.NivelIntensitate.MEDIU, 50);

        System.out.println("Antrenor: " + a1.getNume() + ", Specializare: " + a1.getSpecializare());
        System.out.println("Abonament: " + abonament1.getTip() + ", Pret: " + abonament1.getPret());
        System.out.println("Antrenament: " + antrenament1.getIntensitate() + ", Pret: " + antrenament1.getPret());
    }
}