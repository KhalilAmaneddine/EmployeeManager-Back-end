package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Employee Not Found"));
    }



    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
