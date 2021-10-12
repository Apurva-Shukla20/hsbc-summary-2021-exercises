package com.hsbc.controller;

import java.util.Scanner;

import com.hsbc.beans.Employee;
import com.hsbc.exception.EmployeeAlreadyExistsException;
import com.hsbc.exception.EmployeeNotFoundException;
import com.hsbc.factory.ObjectFactory;
import com.hsbc.service.EmployeeService;

public class ViewController {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ObjectFactory factory = new ObjectFactory();
		EmployeeService service = factory.getServiceInstance();
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
				emp.setId(scan.nextInt());
				System.out.println("Enter name");
				emp.setName(scan.next());
				System.out.println("Enter salary");
				emp.setSalary(scan.nextDouble());
				try {
					service.store(emp);
					System.out.println("Successfully stored.....");
				} catch (EmployeeAlreadyExistsException e1) {
					System.err.println(e1.getMessage());
				}
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("-------Enter id to search --------------");
				int id = scan.nextInt();
				try {
					Employee employee = service.findEmployee(id);
					System.out.println("Employee is found.....");
					System.out.println("Hello " + employee.getName() + ", your salary is : " + employee.getSalary());
				} catch (EmployeeNotFoundException e1) {
					System.err.println(e1.getMessage());
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
				System.out.println("Enter the id of the Employee for which you want to update the name :");
				int nameId = scan.nextInt();
				System.out.println("Enter the Name you want to set :");
				String name = scan.next();
				try {
					service.updateName(nameId, name);
					System.out.println("Employee Details successfully Updated....");
				} catch (EmployeeNotFoundException e2) {
					System.err.println(e2.getMessage());
				}

				break;
			case 5:
				System.out.println("Enter the id of the Employee :");
				int salaryId = scan.nextInt();
				System.out.println("Enter the Salary :");
				double salary = scan.nextDouble();
				try {
					service.updateSalary(salaryId, salary);
					System.out.println("Employee details successfully updated");
				} catch (EmployeeNotFoundException e1) {
					System.err.println(e1.getMessage());
				}

				break;
			}
		} while (controllerOption != 0);
		scan.close();
	}

}