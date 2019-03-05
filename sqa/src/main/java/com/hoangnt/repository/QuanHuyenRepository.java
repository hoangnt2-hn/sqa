package com.hoangnt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangnt.entity.QuanHuyen;

@Repository
@Transactional
public interface QuanHuyenRepository extends JpaRepository<QuanHuyen, String>{
	
}
