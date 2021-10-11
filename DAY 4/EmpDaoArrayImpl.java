package com.example;

public abstract class EmpDaoArrayImpl implements EmpDao {

	private static Employee[] empDb = new Employee[10];
	private static int arrayIndexCounter = 0;

	public void save(Employee employee) {
		empDb[arrayIndexCounter] = employee;
		arrayIndexCounter++;
	}

	public Employee EmpById(int id) {
		for (Employee e : empDb) {
			if (e != null) {
				if (e.getId() == id) {
					return e;
				}
			}
		}
		return null;
	}

	public Employee[] findAllEmployees() {
		Employee[] tempDb = new Employee[arrayIndexCounter];
		for (int index = 0; index < arrayIndexCounter; index++) {
			tempDb[index] = empDb[index];
		}
		return tempDb;
	}

	public void updateEmp(int id, Employee employee) {
		for (Employee em : empDb) {
			if (em != null) {
				if (em.getId() == id) {
					em.setName(employee.getName());
					em.setSalary(employee.getSalary());
				}
			}
		}
	}
}