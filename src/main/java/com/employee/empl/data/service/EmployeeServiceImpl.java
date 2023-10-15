package com.employee.empl.data.service;

import com.employee.empl.data.EmployeesModel;
import com.employee.empl.data.exceptions.EmployeeAlreadyAddedException;
import com.employee.empl.data.exceptions.EmployeeNotFoundException;
import com.employee.empl.data.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<EmployeesModel> employeesList = new ArrayList<>(List.of(
            // ВНИМАНИЕ! ЛЮБЫЕ СОВПАДЕНИЯ СЛУЧАЙНЫ
            new EmployeesModel("Владислав", "Силантьев"),
            new EmployeesModel("Степан", "Степанов"),
            new EmployeesModel("Марина", "Малинина"),
            new EmployeesModel("Имя", "Фамилия"),
            new EmployeesModel("Человек", "Прямоходящий"),
            new EmployeesModel("Программист", "Разработчик"),
            new EmployeesModel("Моисей", "Моисеев")
    ));
    final int MAX_EMPLOYEES = 10;

    public String addEmpl(@RequestParam("firstname") String firstName,
                          @RequestParam("lastname") String lastName) {
        EmployeesModel emp = new EmployeesModel(firstName, lastName);
        if (employeesList.size() > MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников!");
        }
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).equals(emp)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
            }
        }
        employeesList.add(emp);
        return "Успешное добавление сотрудника!";
    }

    public String deletedEmpl(@RequestParam("firstname") String firstName,
                              @RequestParam("lastname") String lastName) {
        EmployeesModel emp = new EmployeesModel(firstName, lastName);
        if (employeesList.contains(emp)) {
            employeesList.remove(emp);
        }
        return "Успешное удаление сотрудника!";
    }

    public String searchEmpl(@RequestParam("firstname") String firstName,
                             @RequestParam("lastname") String lastName) {
        EmployeesModel emp = new EmployeesModel(firstName, lastName);
        int search = 0;
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).equals(emp)) {
                search = i;
            } else {
                throw new EmployeeNotFoundException("Такого сотрудника не существует!");
            }
        }
        return employeesList.get(search).toString();
    }
@Override
    public Collection<EmployeesModel> fullList() {
        return Collections.unmodifiableList(employeesList);
    }
}