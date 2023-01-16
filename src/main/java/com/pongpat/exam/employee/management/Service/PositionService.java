/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pongpat.exam.employee.management.Service;

import com.pongpat.exam.employee.management.Model.Position;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author markd
 */
public interface PositionService {
    public List<Position> findAll();
    
    public Optional<Position> findById(Long id);
}
