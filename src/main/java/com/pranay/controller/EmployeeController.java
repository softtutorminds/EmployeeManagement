package com.pranay.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pranay.model.Employee;
import com.pranay.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public String viewEmployees(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        return "employees";
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/";
    }
}

