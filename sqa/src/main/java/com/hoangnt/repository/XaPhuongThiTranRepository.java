package com.hoangnt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangnt.entity.XaPhuongThiTran;

@Repository
@Transactional
public interface XaPhuongThiTranRepository extends JpaRepository<XaPhuongThiTran, String>{

}
