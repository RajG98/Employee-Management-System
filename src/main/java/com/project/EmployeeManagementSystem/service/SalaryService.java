package com.project.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Scanner;

import com.project.EmployeeManagementSystem.exception.*;
import com.project.EmployeeManagementSystem.model.Employee;
import com.project.EmployeeManagementSystem.model.Salary;
import com.project.EmployeeManagementSystem.repository.EmployeeRepository;
import com.project.EmployeeManagementSystem.repository.SalaryRepository;

public class SalaryService {
	static Scanner sc = new Scanner(System.in);

    private static void processSalary(double salary) {
        if (salary < 10000) {
            throw new InsufficientSalaryException("Salary must be greater than 10000");
        }
    }
    private static Employee checkEmployeeExists(int employeeId) throws EmployeeNotFoundException {
        Employee emp = EmployeeRepository.employeeExists(employeeId);
    	if (emp==null) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found");
        }else return emp;
    }
    private static Salary checkSalary(int id) throws SalaryNotFoundException {
        Salary s = SalaryRepository.checkSalary(id);
    	if (s==null) {
            throw new SalaryNotFoundException("Salary with ID " + id + " not found");
        }else return s;
    }
    private static void validateEmployeeId(String employeeId) throws InvalidEmployeeIdException {
        if (employeeId == null || employeeId.isEmpty()) {
            throw new InvalidEmployeeIdException("Employee ID cannot be null or empty");
        }
    }

    private static void validateSalaryId(String salaryId) throws InvalidSalaryIdException {
        if (salaryId == null || salaryId.isEmpty()) {
            throw new InvalidSalaryIdException("Salary ID cannot be null or empty");
        }
    }

    private static void validatePaymentDate(int paymentDate) throws InvalidPaymentDateException {
        if (paymentDate < 1 || paymentDate > 31) {
            throw new InvalidPaymentDateException("Payment date must be between 1 and 31");
        }
    }

    public static void addSalary() {
        int payment_date;
        String emp_id;
        double salary;
        System.out.print("Enter employee_id: ");
        emp_id = sc.nextLine();
        System.out.print("Enter salary_amount: ");
        salary = sc.nextDouble();
        System.out.print("Enter payment_date: ");
        payment_date = sc.nextInt();
        sc.nextLine();

        try {
            processSalary(salary);
            validateEmployeeId(emp_id);
            Employee emp=checkEmployeeExists(Integer.parseInt(emp_id));
            validatePaymentDate(payment_date);
            SalaryRepository.addSalary(new Salary(emp, salary, payment_date));
        } catch (IllegalArgumentException | InvalidEmployeeIdException | InvalidPaymentDateException | EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewSalary() {
        List<Salary> salaryList=SalaryRepository.viewSalary();
        if(salaryList!=null) {
	        System.out.printf("%-15s %-15s %-20s %-15s%n",
	                "Salary Id", "Employee Name", "Salary", "Payment Date");
	        System.out.println("----------------------------------------------------------------------------");
	        for(Salary s:salaryList) {
	            System.out.printf("%-15s %-15s %-20s %-15s%n",
	                    s.getId(),s.getEmployee().getId(),s.getSalary_amount(),s.getPayment_date());
	        }
	        System.out.println("----------------------------------------------------------------------------");
	    }
    }

    public static void updateSalary() {
        System.out.print("Enter salary Id for update: ");
        String id = sc.nextLine();
        int payment_date;
        int emp_id;
        double salary;
        System.out.print("Enter employee_id: ");
        emp_id = sc.nextInt();
        System.out.print("Enter salary_amount: ");
        salary = sc.nextDouble();
        System.out.print("Enter payment_date: ");
        payment_date = sc.nextInt();
        sc.nextLine();

        try {
            validateSalaryId(id);
            checkSalary(Integer.parseInt(id));
            processSalary(salary);
            validateEmployeeId(String.valueOf(emp_id));
            Employee emp=checkEmployeeExists(emp_id);
            validatePaymentDate(payment_date);
            SalaryRepository.updateSalary(new Salary(emp,salary,payment_date), Integer.parseInt(id));
        } catch (EmployeeNotFoundException | SalaryNotFoundException | IllegalArgumentException | InvalidEmployeeIdException | InvalidSalaryIdException | InvalidPaymentDateException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteSalary() {
        System.out.print("Enter Salary Id to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        try {
            validateSalaryId(String.valueOf(id));
            Salary s = checkSalary(id);
            SalaryRepository.deleteSalary(s);
        } catch (InvalidSalaryIdException | SalaryNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
