/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pongpat.exam.employee.management.Service;

import com.pongpat.exam.employee.management.Model.Employee;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author markd
 */

public interface EmployeeService {
    public void save(Employee employee);
    public List<Employee> findByName(String name);

    public Optional<Employee> findById(Long id);
}
