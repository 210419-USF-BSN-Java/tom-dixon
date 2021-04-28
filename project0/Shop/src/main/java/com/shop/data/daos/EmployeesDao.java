package com.shop.data.daos;

import com.shop.data.models.Employee;

public interface EmployeesDao extends GenericDao<Object> {
	Employee add(Employee e);

	Employee get(int i);

	Employee update(int id, Employee e);

	Integer remove(Employee e);

}
