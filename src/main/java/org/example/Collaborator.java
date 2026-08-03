package org.example;

public class Collaborator extends Trainer{

    private final String company;

    public Collaborator(final String name,
                        final String specialization,
                        final int age,
                        final String company) {

        super(name, specialization, age);

        if (company == null || company.isBlank()) {
            throw new IllegalArgumentException("Company cannot be empty.");
        }

        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String getTrainerType() {
        return "External collaborator";
    }
}
