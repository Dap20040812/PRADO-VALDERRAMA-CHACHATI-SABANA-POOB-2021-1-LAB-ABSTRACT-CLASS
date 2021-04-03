package edu.sabana.poob.sabanapayroll;

import edu.sabana.poob.sabanapayroll.Department;

import java.util.UUID;

public abstract  class Employee {

    private UUID id;
    private String name;
    private String lastname;
    private Department department;
    private BankAccount account;

    public Employee(String name, String lastname, Department department, String tipodeCuenta) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.lastname = lastname;
        this.department = department;
        if(tipodeCuenta.equals("Checking"))
        {
            Checking account = new Checking();
            this.account = account;
        }
        if (tipodeCuenta.equals("Saving"))
        {
            Savings account = new Savings();
            this.account = account;
        }
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

    public BankAccount getAccount() {
        return account;
    }
}
