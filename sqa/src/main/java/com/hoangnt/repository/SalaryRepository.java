package com.hoangnt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangnt.entity.Salary;

@Transactional
@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}
