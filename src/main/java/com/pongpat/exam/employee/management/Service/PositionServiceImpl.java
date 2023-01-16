/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pongpat.exam.employee.management.Service;

import com.pongpat.exam.employee.management.Model.Position;
import com.pongpat.exam.employee.management.Repository.PositionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author markd
 */
@Service("positionService")
@Transactional
public class PositionServiceImpl implements PositionService{

    @Autowired
    PositionRepository positionRepository;
    
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(Long id) {
        
        return positionRepository.findById(id);
    }
    
}
