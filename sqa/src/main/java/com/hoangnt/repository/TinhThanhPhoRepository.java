package com.hoangnt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangnt.entity.TinhThanhPho;

@Repository
@Transactional
public interface TinhThanhPhoRepository extends JpaRepository<TinhThanhPho, String>{
	
}
