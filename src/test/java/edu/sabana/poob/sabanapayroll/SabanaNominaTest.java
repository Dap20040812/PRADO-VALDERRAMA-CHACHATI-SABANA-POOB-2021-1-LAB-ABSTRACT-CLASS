package edu.sabana.poob.sabanapayroll;

import edu.sabana.poob.sabanapayroll.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        e1 = new EmployeeBySalary("E","R",d,120,"Saving");
        e2 = new EmployeeByHours("R","T",d1,5,"Checking");
        e3 = new EmployeeByCommission("T","Y",d,6,"Checking");
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

    @Test
    public void ShouldDepositToEmployee(){

        assertTrue(s.depositToEmployee(e1.getId(),10000));
        assertTrue(Double.compare(8000,e1.getAccount().getBalance())== 0);
        assertFalse(s.depositToEmployee(e2.getId(),5000));
        assertTrue(Double.compare(0,e2.getAccount().getBalance())== 0);
        assertTrue(s.depositToEmployee(e3.getId(),6000));
        assertTrue(Double.compare(1000,e3.getAccount().getBalance())== 0);

    }

    @Test
    public void ShouldCalculateEmployeeBalance(){

        double a = s.calculateEmployeeBalance(e1.getId());
        double b = s.calculateEmployeeBalance(e2.getId());
        double c = s.calculateEmployeeBalance(e3.getId());

        assertTrue(s.depositToEmployee(e1.getId(),10000));
        assertTrue(Double.compare(8000+a,s.calculateEmployeeBalance(e1.getId()))== 0);
        assertFalse(s.depositToEmployee(e2.getId(),5000));
        assertTrue(Double.compare(0+b,s.calculateEmployeeBalance(e2.getId()))== 0);
        assertTrue(s.depositToEmployee(e3.getId(),6000));
        assertTrue(Double.compare(1000+c,s.calculateEmployeeBalance(e3.getId()))== 0);

    }

    @Test
    public void ShouldCalculateAllEmployeeBalance(){

        double a = s.calculateEmployeeBalance(e1.getId());
        double b = s.calculateEmployeeBalance(e2.getId());
        double c = s.calculateEmployeeBalance(e3.getId());
        assertTrue(s.depositToEmployee(e1.getId(),10000));
        assertTrue(Double.compare(8000+a,s.calculateEmployeeBalance(e1.getId()))== 0);
        assertFalse(s.depositToEmployee(e2.getId(),5000));
        assertTrue(Double.compare(0+b,s.calculateEmployeeBalance(e2.getId()))== 0);
        assertTrue(s.depositToEmployee(e3.getId(),6000));
        assertTrue(Double.compare(1000+c,s.calculateEmployeeBalance(e3.getId()))== 0);
        assertTrue(Double.compare(9000+a+b+c,s.calculateAllEmployeeBalance())== 0);

    }

}
