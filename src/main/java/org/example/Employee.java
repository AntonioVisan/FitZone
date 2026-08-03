package org.example;

public class Employee extends Trainer {

    private final double salary;

    public Employee(final String name,
                    final String specialization,
                    final int age,
                    final double salary) {

        super(name, specialization, age);

        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater than zero.");
        }

        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String getTrainerType() {
        return "Permanent employee";
    }
}
