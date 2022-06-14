package com.controller;

import com.model.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MyController {


    private final EmployeeService employeeService;

    @Autowired
    public MyController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/")
    public String showAllEmployees(Model model) {
        model.addAttribute("allEmp", employeeService.getAllEmployees());
        return "all-employees";
    }


    @GetMapping("/employee-save")
    public String saveEmployeeForm(Employee employee) {
        return "employee-save";
    }

    @PostMapping("/employee-save")
    public String saveEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/employee-delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    @GetMapping("/employee-update/{id}")
    public String updateEmployeeForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "employee-update";
    }

    @PostMapping("/employee-update")
    public String updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }
}
