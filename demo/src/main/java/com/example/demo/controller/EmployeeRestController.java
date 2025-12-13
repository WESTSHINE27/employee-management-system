package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {

    private final EmployeeService service;

    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return service.save(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return service.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
