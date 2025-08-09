package com.learnwithK.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "employee", schema = "public")
public class Employee {
    @Id
    @Column(name= "employee_id")
    private int id;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name="department")
    private String department;

}
