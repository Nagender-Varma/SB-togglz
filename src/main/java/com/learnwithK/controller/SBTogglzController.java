package com.learnwithK.controller;

import com.learnwithK.entity.Employee;
import com.learnwithK.services.EmployeeService;
import com.learnwithK.utils.MyFeatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.togglz.core.manager.FeatureManager;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class SBTogglzController {
    @Autowired
    EmployeeService empService;

    private final FeatureManager featureManager;

    public SBTogglzController(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }


    @GetMapping(value = "/v1/get-employee")
    public Optional<Employee> getEmployeeDetails(@RequestParam int employeeId) {
        Optional<Employee> emp;
        try {
            emp = empService.getEmployee(employeeId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return emp;
    }

    @GetMapping(value = "/v1/getEmployees")
    public List<Employee> getAllEmployees() {
        List<Employee> employees;
        try {
            employees = empService.getEmployees();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @PostMapping(value = "/v1/save-employee")
    public String saveEmployeeDetails(@RequestBody Employee emp) {
        String result;
        try {
            if (featureManager.isActive(MyFeatures.ALLOW_EMPLOYEE_SAVE)) {
                result = empService.saveEmployee(emp);
            }else{
                result = "Not Allowed";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
