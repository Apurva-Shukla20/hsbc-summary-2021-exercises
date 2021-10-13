package com.hsbc.controller;

import java.util.Scanner;

import com.hsbc.beans.Employee;
import com.hsbc.exception.EmployeeAlreadyExistException;
import com.hsbc.exception.EmployeeNotFoundException;
import com.hsbc.factory.ObjectFactory;
import com.hsbc.service.EmployeeService;

public class ViewController {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		EmployeeService service = FactoryPattern.getServiceInstance();
		int controllerOption = 0;
		do {
			System.out.println("Enter options:-");
			System.out.println(
					"1: Store employee 2: Find employee by id 3: Find All employees 4: Update Name 5: Update Salary 0: Exit");
			controllerOption = scan.nextInt();
			switch (controllerOption) {
			case 1:
				System.out.println("--- Enter employee details ------");
				Employee emp = new Employee();
				System.out.println("Enter id");
				emp.setId(scan.nextInt()); // instead of int id = scan.nextInt(); emp.setId(id);
				System.out.println("Enter name");
				emp.setName(scan.next());
				System.out.println("Enter salary");
				emp.setSalary(scan.nextDouble());
				try {
					service.store(emp);
					System.out.println("Successfully stored.....");
					System.out.println("---------------------------------");
				} catch (EmployeeAlreadyExistException e3) {
					System.err.println(e3.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter the employee id you want to fetch the details of:");
				int id = scan.nextInt();
				try {
					Employee e1 = service.findEmployee(id);
					System.out.println("Employee is found.....");
					System.out.println("The details are: Name :" + e1.getName() + " " + "Salary :" + e1.getSalary());
				} catch (EmployeeNotFoundException e2) {
					System.err.println(e2.getMessage());
				}
				break;
			case 3:
				Employee[] employees = service.findAllEmployees();
				for (Employee e : employees) {
					System.out.println("Hello " + e.getName() + ", Your salary is: " + e.getSalary() + " and id is : "
							+ e.getId());
				}
				break;
			case 4:
				System.out.println("Enter the employee id that you want to update the name: ");
				int id1 = scan.nextInt();
				System.out.println("Enter the new name :");
				String name = scan.next();

				Employee e;
				try {
					e = service.findEmployee(id1);
					service.updateName(id1, name);
					System.out.println("Employee found");
					System.out.println(
							"Updated Name:" + e.getName() + " " + "Salary:" + e.getSalary() + " " + "Id:" + e.getId());
				} catch (EmployeeNotFoundException e1) {
					System.err.println(e1.getMessage());
				}

				break;
			case 5:

				System.out.println("Enter the employee id: ");
				int id2 = scan.nextInt();
				System.out.println("Enter the new salary :");
				Double salary = scan.nextDouble();
				Employee emp1;
				try {
					emp1 = service.findEmployee(id2);
					service.updateSalary(id2, salary);
					System.out.println("Employee found");
					System.out.println(
							"Name:" + emp1.getName() + " " + "Salary:" + emp1.getSalary() + " " + "Id:" + emp1.getId());
				} catch (EmployeeNotFoundException e1) {
					System.err.println(e1.getMessage());
				}
				break;

			}
		} while (controllerOption != 0);
		scan.close();
	}

}