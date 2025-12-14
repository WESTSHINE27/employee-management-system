package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeKafkaProducer kafkaProducer;

    public EmployeeService(EmployeeRepository repository, EmployeeKafkaProducer kafkaProducer) {
        this.repository = repository;
        this.kafkaProducer = kafkaProducer;
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee save(Employee employee) {
        Employee saved = repository.save(employee);
        kafkaProducer.sendMessage("employee.created", saved.getId().toString());
        return repository.save(saved);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
