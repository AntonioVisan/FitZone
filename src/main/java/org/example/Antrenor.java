package org.example;

public class Antrenor {
    private String nume;
    private String specializare;
    private Integer age;

    public enum TipAngajat {
        ANGAJAT_PERMANENT,
        COLABORATOR_EXTERN
    }

    private TipAngajat tip;
    public Antrenor(String nume, String specializare, Integer age, TipAngajat tip) {
        this.nume = nume;
        this.specializare = specializare;
        this.age = age;
        this.tip = tip;
    }

    public String getNume() {
        return nume;
    }

    public String getSpecializare() {
        return specializare;
    }

    public Integer getAge() {
        return age;
    }

    public TipAngajat getTip() {
        return tip;
    }
}
