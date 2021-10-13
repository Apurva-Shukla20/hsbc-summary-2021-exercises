package com.hsbc.service;

import java.util.List;
import java.util.Set;

import com.hsbc.beans.Employee;
import com.hsbc.dao.EmployeeDao;
import com.hsbc.dao.EmployeeDaoArrayImpl;
import com.hsbc.exception.EmployeeAlreadyExistException;
import com.hsbc.exception.EmployeeNotFoundException;
import com.hsbc.factory.ObjectFactory;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao = ObjectFactory.getDaoInstance();
	EmployeeDao dao1 = ObjectFactory.getDaoListInstance();
	EmployeeDao dao2 = ObjectFactory.getDaoSetInstance();

	@Override
	public void store(Employee employee) throws EmployeeAlreadyExistException {
		dao.save(employee);
	}

	@Override
	public Employee findEmployee(int id) throws EmployeeNotFoundException {

		Employee emp = dao.fetchEmployeeById(id);
		if (emp == null) {
			throw new EmployeeNotFoundException("Sorry employee with an id " + id + " not found");
		}
		return emp;
	}

	@Override
	public Employee[] findAllEmployees() {
		return dao.findAllEmployees();
	}

	@Override
	public void updateSalary(int id, double salary) throws EmployeeNotFoundException {
		Employee e = dao.fetchEmployeeById(id);
		if (e == null) {
			throw new EmployeeNotFoundException("Sorry employee with an id " + id + " not found to update");
		}
		e.setSalary(salary);
		dao.updateEmployee(id, e);
	}

	@Override
	public void updateName(int id, String name) throws EmployeeNotFoundException {
		Employee e = dao.fetchEmployeeById(id);
		if (e == null) {
			throw new EmployeeNotFoundException("Sorry employee with an id " + id + " not found to update");
		}
		e.setName(name);
		dao.updateEmployee(id, e);
	}

}