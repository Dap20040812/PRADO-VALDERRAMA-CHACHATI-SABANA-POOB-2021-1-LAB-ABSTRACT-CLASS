package edu.sabana.poob.sabanapayroll;

import edu.sabana.poob.sabanapayroll.Department;

import java.util.UUID;

public abstract  class Employee {

    private UUID id;
    private String name;
    private String lastname;
    private Department department;
    private BankAccount account;

    public Employee(String name, String lastname, Department department) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.lastname = lastname;
        this.department = department;
    }

    public abstract double calculateSalary();

    /**
     * Este metodo imprime al empleado y sus caracteristicas.
     * @return String las caracteristicas del empleado.
     */

    @Override
    public String toString() {
        return String.format("%s %s, department %s, salary %s", this.name, this.lastname, this.department.getName(), this.calculateSalary());
    }

    public String getName(){return name;}

    public String getLastname() {
        return lastname;
    }

    public UUID getId() {
        return id;
    }
}
