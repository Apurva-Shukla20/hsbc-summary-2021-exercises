package com.example;

public interface EmpDao {
	public void save(Employee employee);

	public Employee fetchEmployeeById(int id);

	public Employee[] findAllEmployees();

	public void updateEmployee(int id, Employee employee);
}