package com.hoangnt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangnt.entity.Coefficient;

@Transactional
@Repository
public interface CoefficientRepository extends JpaRepository<Coefficient, Integer>{

}
