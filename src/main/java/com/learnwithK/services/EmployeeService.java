package com.learnwithK.services;

import com.learnwithK.entity.Employee;
import com.learnwithK.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    public Optional<Employee> getEmployee(int employeeId){
        return empRepo.findById(employeeId);
    }

    public List<Employee> getEmployees() {
        return empRepo.findAll();
    }

    public String saveEmployee(Employee emp) {
        return empRepo.save(emp).toString();
    }
}
