package com.momo;

import java.time.LocalDate;
import java.time.Month;

public class EmployeeTest {

    public static void main(String[] args) {

        //Creating of birthday of each employee
        LocalDate saleEmpBirthdate = LocalDate.of(1987, Month.JANUARY, 27);
        LocalDate hourlyEmpBirthday = LocalDate.of(1974, Month.DECEMBER, 21);
        LocalDate commEmpBirthday = LocalDate.of(1978, Month.JULY, 25);
        LocalDate baseEmpBirthday = LocalDate.of(1985, Month.AUGUST, 23);
        // Creating an array of abstract class
        Employee[] employees = new Employee[5];
        employees[0] = new SalariedEmployee("James", "Gray", "222-78-9067", 30000, saleEmpBirthdate);
        employees[1] = new HourlyEmployee("Momo", "Johnson", "345-78-9087", 15, 150, hourlyEmpBirthday);
        employees[2] = new CommissionEmployee("Philip", "Kiazolu", "456-90-8976", 75000, 0.76, commEmpBirthday);
        employees[3] = new BasePlusCommissionEmployee("Sheveil", "Johnson", "345-89-9040", 5000, 0.04, 300, baseEmpBirthday);
        employees[4] = new PieceWorker("Philip", "Kromah", "345-76-9078", 27.00, 56, baseEmpBirthday);

        // Creating an array of payable interface
        Payable[] payables = new Payable[7];
        payables[0] = new SalariedEmployee("James", "Gray", "222-78-9067", 30000, saleEmpBirthdate);
        payables[1] = new HourlyEmployee("Momo", "Johnson", "345-78-9087", 15, 150, hourlyEmpBirthday);
        payables[2] = new CommissionEmployee("Philip", "Kiazolu", "456-90-8976", 75000, 0.76, commEmpBirthday);
        payables[3] = new BasePlusCommissionEmployee("Sheveil", "Johnson", "345-89-9040", 5000, 0.04, 300, baseEmpBirthday);
        payables[4] = new Invoice("6754", "pump", 30, 50.00);
        payables[5] = new PieceWorker("Philip", "Kromah", "345-76-9078", 27.00, 56, baseEmpBirthday);
        payables[6] = new Invoice("5678", "screwdirver", 56,23.00);

        System.out.println("Processing emplyees using abstract employee class philosophically");
        for (Employee currentEmployee : employees) {

            // If the current employee is a base plus commission employee, increase base salary by 10%
            if (currentEmployee instanceof BasePlusCommissionEmployee)
            {

                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary((0.10* employee.getBaseSalary()+employee.getBaseSalary()));
                System.out.println("After increasing base salary by 10%");
            }


            System.out.println(currentEmployee.toString());
            System.out.println();

        }

        System.out.println("Processing employees using payable interface philosophically");
        System.out.println();

        for(Payable payable: payables){
            // If an employee is a base plus commission employee, base salary is increased by 10%
            if (payable instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) payable;
                employee.setBaseSalary(0.10 * employee.getBaseSalary()+employee.getBaseSalary());
            }
            System.out.println(payable.toString());
            System.out.println();
        }
    }
}
