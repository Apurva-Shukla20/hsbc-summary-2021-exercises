package com.example;

public interface EmpService {
	public void store(Employee employee);

	public Employee findEmp(int id);

	public Employee[] findEmp();

	public void updateSalary(int id, double salary);

	public void updateName(int id, String name);
}