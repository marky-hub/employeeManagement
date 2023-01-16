/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pongpat.exam.employee.management.Repository;

import com.pongpat.exam.employee.management.Model.Employee;
import com.pongpat.exam.employee.management.bean.EmployeeSearchFormData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author markd
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
     public List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

}
