package com.project.EmployeeManagementSystem;

import java.util.Scanner;

import static com.project.EmployeeManagementSystem.service.EmployeeService.*;
import static com.project.EmployeeManagementSystem.service.SalaryService.*;
import static com.project.EmployeeManagementSystem.service.ShiftService.*;

/**
 * Hello world!
 *
 */
public class App 
{
    	static Scanner sc=new Scanner(System.in);

        private static void manageEmployee(){
            while (true){
                System.out.println("-----------------------");
                System.out.println("1. Add a new employee");
                System.out.println("2. View employee details");
                System.out.println("3. Update employee information");
                System.out.println("4. Delete an employee");
                System.out.println("5. Return to menu");
                System.out.println("6. Exit");
                System.out.println("-----------------------");

                int choice=sc.nextInt();
                switch(choice){
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployeeDetails();
                        break;
                    case 3:
                        updateEmployeeInfo();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        return;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            }
        }
        private static void manageShift(){
            while (true){
                System.out.println("-----------------------");
                System.out.println("1. Assign a shift to an employee");
                System.out.println("2. View shift details");
                System.out.println("3. Update shift information");
                System.out.println("4. Delete a shift");
                System.out.println("5. Return to menu");
                System.out.println("6. Exit");
                System.out.println("-----------------------");

                int choice=sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        addShift();
                        break;
                    case 2:
                        getShiftDetails();
                        break;
                    case 3:
                        updateShift();
                        break;
                    case 4:
                        deleteShift();
                        break;
                    case 5:
                        return;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            }
        }
        private static void manageSalary(){
            while (true){
                System.out.println("-----------------------");
                System.out.println("1. Set a salary for an employee");
                System.out.println("2. View salary details");
                System.out.println("3. Update salary information");
                System.out.println("4. Delete a salary record");
                System.out.println("5. Return to menu");
                System.out.println("6. Exit");
                System.out.println("-----------------------");

                int choice=sc.nextInt();
                switch(choice){
                    case 1:
                        addSalary();
                        break;
                    case 2:
                        viewSalary();
                        break;
                    case 3:
                        updateSalary();
                        break;
                    case 4:
                        deleteSalary();
                        break;
                    case 5:
                        return;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            }
        }
        public static void main(String[] args) {

            while (true){
                System.out.println("-----------------------");
                System.out.println("Employee Management System");
                System.out.println("1. Manage Employee");
                System.out.println("2. Manage Shift");
                System.out.println("3. Manage Salary");
                System.out.println("4. Exit");
                System.out.println("-----------------------");
                int choice=sc.nextInt();
                switch(choice){
                    case 1:
                        manageEmployee();
                        break;
                    case 2:
                        manageShift();
                        break;
                    case 3:
                        manageSalary();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            }
        }


    
}
