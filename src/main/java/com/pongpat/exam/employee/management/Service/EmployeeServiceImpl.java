/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pongpat.exam.employee.management.Service;

import com.pongpat.exam.employee.management.Model.Employee;
import com.pongpat.exam.employee.management.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author markd
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> findByName(String name) {
        List<Employee> employeeList = employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name,name);
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }
    
}
