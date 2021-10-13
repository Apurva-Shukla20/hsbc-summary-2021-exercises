package com.hsbc.dao;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.beans.Employee;
import com.hsbc.exception.EmployeeAlreadyExistException;

public class EmployeeDaoArrayListImpl implements EmployeeDao {

	private static List<Employee> employees1 = new ArrayList<Employee>();

	@Override
	public void save(Employee employee) throws EmployeeAlreadyExistException {
		employees1.add(employee);

		for (int i = 0; i < employees1.size(); i++) {
			if (employee.getId() == employees1.get(i).getId()) {
				throw new EmployeeAlreadyExistException("Employee Already exist");
			}
		}
	}

	@Override
	public Employee[] findAllEmployees() {

		return null;
	}

	@Override
	public Employee fetchEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(int id, Employee employee) {
		for (Employee em : employees1) {
			if (em != null) {
				if (em.getId() == id) {
					em.setName(employee.getName());
					em.setSalary(employee.getSalary());
				}
			}
		}

	}

}