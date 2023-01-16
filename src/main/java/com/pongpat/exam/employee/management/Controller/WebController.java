/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pongpat.exam.employee.management.Controller;

import com.pongpat.exam.employee.management.Model.Employee;
import com.pongpat.exam.employee.management.Model.Position;
import com.pongpat.exam.employee.management.Service.EmployeeService;
import com.pongpat.exam.employee.management.Service.PositionService;
import com.pongpat.exam.employee.management.bean.CreateForm;
import com.pongpat.exam.employee.management.bean.EditForm;
import com.pongpat.exam.employee.management.bean.EmployeeSearchFormData;
import jakarta.servlet.http.HttpServletRequest;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author markd
 */
@Controller
public class WebController {
    
    
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    PositionService positionService;
    
    @GetMapping("/")
    public String Main(HttpServletRequest request, ModelMap model){
        model.addAttribute("employeeSearchFormData",new EmployeeSearchFormData());
        return "index";
    }
    
    @PostMapping("/employee/search")
     public String doSearchEmployee(@ModelAttribute("employeeSearchFormData") EmployeeSearchFormData searchFormData, Model model) {
            List<Employee> empList = employeeService.findByName(searchFormData.getName());
            model.addAttribute("empList", empList);
            return "index";            
     }
     
    @GetMapping("/employee/create")
    public String createEmployee(Model model) {
        model.addAttribute("createForm", new CreateForm());
        model.addAttribute("positions", positionService.findAll());
        return "employee-create";
    }
    
    @PostMapping("/employee/create")
    public String createEmployee(CreateForm createForm) {
        Employee employee = new Employee();
        employee.setFirstName(createForm.getFirstName());
        employee.setLastName(createForm.getLastName());
        employee.setCardId(createForm.getCardId());
        employee.setBirthday(createForm.getBirthday());
        employee.setAddress(createForm.getAddress());
        employee.setStartDate(new Date());
        employee.setPhone(createForm.getPhone());
        Optional<Position> position = positionService.findById(createForm.getPositionId().longValue());

        if (position.isPresent()) {
            employee.setPosition(position.get());
        } else {
            System.out.printf("No position found with id %d%n", createForm.getPositionId());
        }
        
        //save the employee
        employeeService.save(employee);
        return "redirect:/";
    }
    
    @GetMapping("/employee/edit")
    public String editEmployee(@RequestParam Long id,Model model) {
        Optional<Employee> employeeOptional = employeeService.findById(id);
        EditForm editForm = new EditForm();
        Employee employee = employeeOptional.get();
        editForm.setId(employee.getId());
        editForm.setFirstName(employee.getFirstName());
        editForm.setLastName(employee.getLastName());
        editForm.setCardId(employee.getCardId());
        editForm.setAddress(employee.getAddress());
        editForm.setBirthday(employee.getBirthday());
        editForm.setPhone(employee.getPhone());
        editForm.setStartDate(employee.getStartDate());
        editForm.setEndDate(employee.getEndDate());
        if(employee.getPosition() != null){
            editForm.setPositionId(employee.getPosition().getId());
        }else{
            editForm.setPositionId(null);
        }
        model.addAttribute("editForm", editForm);
        model.addAttribute("positions", positionService.findAll());
        return "employee-edit";
    }
    
    @PostMapping("/employee/edit")
    public String editEmployee(@RequestParam Long id,EditForm editForm) {
        Employee employee = employeeService.findById(id).get();
        employee.setFirstName(editForm.getFirstName());
        employee.setLastName(editForm.getLastName());
        employee.setCardId(editForm.getCardId());
        employee.setBirthday(editForm.getBirthday());
        employee.setAddress(editForm.getAddress());
        employee.setPhone(editForm.getPhone());
        employee.setEndDate(null);
        Optional<Position> position = positionService.findById(editForm.getPositionId().longValue());

        if (position.isPresent()) {
            employee.setPosition(position.get());
        } else {
            System.out.printf("No position found with id %d%n", editForm.getPositionId());
        }
        
        //save the employee
        employeeService.save(employee);
        return "redirect:/";
    }
    
    @PostMapping("/employee/retire")
    public String retireEmployee(@RequestParam Long id) {
        Employee employee = employeeService.findById(id).get();
        employee.setEndDate(new Date());
        Position position = employee.getPosition();

        if (position != null) {
            employee.setPosition(null);
        }
        
        //save the employee
        employeeService.save(employee);
        return "redirect:/";
    }
}
