package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/find/all")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }



    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
    }

}
