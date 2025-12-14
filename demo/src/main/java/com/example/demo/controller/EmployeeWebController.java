package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeWebController {

    private final EmployeeService service;

    public EmployeeWebController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        System.out.println("find all calling");
        System.out.println(service.findAll());
        model.addAttribute("employees", service.findAll());
        return "employees";
    }

    @GetMapping("/employees/new")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "create-employee";
    }

    @PostMapping("/employees")
    public String save(@ModelAttribute Employee employee) {
        service.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", service.findById(id));
        return "edit-employee";
    }

    @PostMapping("/employees/update")
    public String update(Employee employee) {
        service.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/employees";
    }
}
