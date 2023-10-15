package com.employee.empl.data.service;

import com.employee.empl.data.EmployeesModel;
import com.employee.empl.data.exceptions.EmployeeAlreadyAddedException;
import com.employee.empl.data.exceptions.EmployeeNotFoundException;
import com.employee.empl.data.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;

public interface EmployeeService {
    String addEmpl(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    EmployeesModel deletedEmpl(String firstName, String lastName);

    String searchEmpl(String firstName, String lastName) throws EmployeeNotFoundException;

    Collection<EmployeesModel> fullList();
}
