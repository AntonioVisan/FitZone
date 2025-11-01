package org.example;

public abstract class Antrenor {
    private String nume;
    private String specializare;
    private Integer age;

    public Antrenor(String nume, String specializare, Integer age) {
        this.nume = nume;
        this.specializare = specializare;
        this.age = age;
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

    public abstract String getTip();
}
