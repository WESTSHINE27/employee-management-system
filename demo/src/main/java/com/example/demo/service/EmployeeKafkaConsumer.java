package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeKafkaConsumer {
    private final EmailService emailService;
    private final EmployeeRepository repository;

    public EmployeeKafkaConsumer(EmailService emailService, EmployeeRepository repository) {
        this.emailService = emailService;
        this.repository = repository;
    }

    @KafkaListener(topics = {"employee.created"})
    public void listen(String id) {
        try {
            System.out.println("Received Kafka message: " + id);
            long employeeId = Long.parseLong(id);
            Employee employee = repository.findById(employeeId).orElse(null);
            if(employee != null){
                emailService.sendEmail(
                        employee.getEmail(),
                        "Employee Created Notification",
                        "congratulations!! Your employee account successfully created!"
                );
            } else {
                System.out.println("Employee not found for ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid employee id received: " + id);
        } catch (Exception e) {
            System.err.println("Error processing employee: " + e.getMessage());
            // Optional: log stacktrace
            e.printStackTrace();
        }
    }

}
