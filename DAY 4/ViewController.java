package com.example;

import com.example.EmpServiceImpl;

import java.util.Scanner;

public class ViewController {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		EmpService service = new EmpServiceImpl();
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
				etId(id);
				System.out.println("Enter name");
				emp.setName(scan.next());
				System.out.println("Enter salary");
				emp.setSalary(scan.nextDouble());
				service.store(emp);
				System.out.println("Successfully stored.....");
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("Enter the employee id you want to fetch the details of:");
				int id = scan.nextInt();
				Employee e1 = service.findEmp(id);
				// e1.setId(id);
				System.out.println("The details are: Name :" + e1.getName() + " " + "Salary :" + e1.getSalary());
				break;
			case 3:
				Employee[] employees = service.findEmp();
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
				service.updateName(id1, name);
				Employee e = service.findEmp(id1);
				System.out.println("The updated name detail is... Name:" + e.getName() + " " + "Salary:" + e.getSalary()
						+ " " + "Id:" + e.getId());
				break;
			case 5:

				System.out.println("Enter the employee id that you want to update the salary: ");
				int id2 = scan.nextInt();
				System.out.println("Enter the new salary :");
				Double salary = scan.nextDouble();
				service.updateSalary(id2, salary);
				Employee emp1 = service.findEmp(id2);
				System.out.println("The updated salary detail is... Name:" + emp1.getName() + " " + "Salary:"
						+ emp1.getSalary() + " " + "Id:" + emp1.getId());
				break;
			}
		} while (controllerOption != 0);
		scan.close();
	}

}