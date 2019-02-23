package com.hoangnt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangnt.entity.Area;

@Transactional
@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{

}
