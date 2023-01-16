/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pongpat.exam.employee.management.Repository;

import com.pongpat.exam.employee.management.Model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author markd
 */
@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{
    
}
