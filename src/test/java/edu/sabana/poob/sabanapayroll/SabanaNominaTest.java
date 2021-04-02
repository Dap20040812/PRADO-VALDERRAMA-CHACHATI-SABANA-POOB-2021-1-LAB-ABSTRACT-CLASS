package edu.sabana.poob.sabanapayroll;

import edu.sabana.poob.sabanapayroll.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SabanaNominaTest {
    private static EmployeeBySalary e1;
    private static EmployeeByHours e2;
    private static EmployeeByCommission e3;
    private static SabanaPayroll s;
    private static Department d;
    private static Department d1;

    @BeforeAll
    public static void setUp(){

        s = new SabanaPayroll();
        d = new Department("D");
        d1 = new Department( "D1");
        s.addDepartment(d);
        s.addDepartment(d1);
        e1 = new EmployeeBySalary("E","R",d,120);
        e2 = new EmployeeByHours("R","T",d1,5);
        e3 = new EmployeeByCommission("T","Y",d,6);
        d.addEmployee(e1);
        d.addEmployee(e3);
        d1.addEmployee(e2);
    }
    @Test
    public void ShouldCalculateEmployeeSalary(){

        assertEquals(110.4,s.calculateEmployeeSalary(e1.getId()));
        assertEquals(17.5,s.calculateEmployeeSalary(e2.getId()));
        assertEquals(21,s.calculateEmployeeSalary(e3.getId()));

    }
    @Test
    public void ShouldCalculateDepartmentSalaries(){

        assertEquals(131.4,s.calculateDepartmentSalaries(d.getId()));
        assertEquals(17.5,s.calculateDepartmentSalaries(d1.getId()));

    }
    @Test
    public void ShouldCalculateUSalaries(){

        assertEquals(148.9,s.calculateUniversitySalaries());

    }

    @Test
    public void ShouldPrintEmployees(){

        assertEquals("E R, department D, salary 110.4 payment by salary" ,e1.toString());
        assertEquals("R T, department D1, salary 17.5 payment by hours" ,e2.toString());
        assertEquals("T Y, department D, salary 21.0 payment by commission" ,e3.toString());
    }

    @Test
    public void ShouldPrintEmployeesArrayList(){
        ArrayList<String> a = new ArrayList<>();

        a.add("E R, department D, salary 110.4 payment by salary");
        a.add("R T, department D1, salary 17.5 payment by hours");
        a.add("T Y, department D, salary 21.0 payment by commission");

        System.out.println(a);
        s.printPayroll();


    }
}
