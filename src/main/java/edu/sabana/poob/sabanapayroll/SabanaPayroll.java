package edu.sabana.poob.sabanapayroll;

import edu.sabana.poob.sabanapayroll.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SabanaPayroll {

    private ArrayList<Department> departments;
    public SabanaPayroll() {
        this.departments = new ArrayList<>();
    }

    /**
     * Este metod suma todos los salarios de todos los empleados de un deprtaento.
     * @param idDepartment
     * @return double Salarios de un departamento especifico
     */
    public double calculateDepartmentSalaries(UUID idDepartment){

        double DepartmentSalary = 0;
        for(Department d:this.departments){

            if (d.getId()==idDepartment){
                DepartmentSalary = d.calculateDepartmentSalaries();
            }
        }
        return DepartmentSalary;
    }
    /**
     * Este metodo calcula el salario de un empleado en especifico.
     * @param idEmployee
     * @return double salario de un empleado
     */
    public double calculateEmployeeSalary(UUID idEmployee){

        double EmploySalary = 0;
        for(Department d:this.departments){
            EmploySalary+=d.findSalaryEmployee(idEmployee);
        }
        return EmploySalary;
    }
    /**
     * Este metodo suma todos los salarios de todos los departamentos.
     * @return double Salario de toda la universidad
     */
    public double calculateUniversitySalaries(){

        double USalary = 0;
        for(Department d:this.departments){

            USalary += d.calculateDepartmentSalaries();
        }
        return USalary;
    }
    /**
     * Imprime la lista de todos los empeados en la nomina de la universidad.
     */
    public void printPayroll(){

        List<String> names = departments.stream().map(department -> department.printEmployees()).flatMap(List::stream).collect(Collectors.toList());
        for(int i=0;i< names.size();i++)
        {
            System.out.println("\t"+names.get(i));
        }

    }
    /**
     * Añade un departamento a la lista de departamentos de la universidad.
     * @param department
     */
    public void addDepartment(Department department)
    {
        departments.add(department);
    }





}
