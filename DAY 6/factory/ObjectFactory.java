package com.hsbc.factory;

import com.hsbc.dao.EmployeeDao;
import com.hsbc.dao.EmployeeDaoArrayImpl;
import com.hsbc.dao.EmployeeDaoArrayListImpl;
import com.hsbc.dao.EmployeeDaoTreeSetImpl;
import com.hsbc.service.EmployeeService;
import com.hsbc.service.EmployeeServiceImpl;

public class ObjectFactory {

	public static EmployeeDao getDaoInstance() {
		
		return new EmployeeDaoArrayImpl();
	}

	public static EmployeeService getServiceInstance() {
		
		return new EmployeeServiceImpl();
	}

	public static EmployeeDao getDaoListInstance() {
		
		return new EmployeeDaoArrayListImpl();
	}

	public static EmployeeDao getDaoSetInstance() {
		
		return new EmployeeDaoTreeSetImpl();
	}
	
	
}