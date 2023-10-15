package com.employee.empl.data.controller;

import com.employee.empl.data.EmployeesModel;
import com.employee.empl.data.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class ControllerEmployees {
    public final EmployeeService empl;

    public ControllerEmployees(EmployeeService empl) {
        this.empl = empl;
    }

    @GetMapping()
    public Collection<EmployeesModel> fullEmpl() {
        return empl.fullList();
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return empl.addEmpl(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public String removeEmpl(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return empl.deletedEmpl(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public String findEmpl(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return empl.searchEmpl(firstName, lastName);
    }
}
