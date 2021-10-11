package com.example;

import com.example.EmpDaoArrayImpl;

public abstract class EmpServiceImpl implements EmpService {
	private EmpDao dao = null;

	public EmpServiceImpl() {
		// this is wrong approach we need to use factory pattern
		dao = new EmpDaoArrayImpl();
	}

	public void store(Employee employee) {
		dao.save(employee);
	}

	public Employee findEmployee(int id) {

		return dao.fetchEmployeeById(id);
	}

	public Employee[] findAllEmployees() {
		return dao.findAllEmployees();
	}

	public void updateSalary(int id, double salary) {
		Employee e = dao.fetchEmployeeById(id);
		e.setSalary(salary);
		dao.updateEmployee(id, e);
	}

	public void updateName(int id, String name) {
		Employee e = dao.fetchEmployeeById(id);
		e.setName(name);
		dao.updateEmployee(id, e);
	}

}