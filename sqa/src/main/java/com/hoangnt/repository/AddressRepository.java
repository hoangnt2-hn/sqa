package com.hoangnt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangnt.entity.Address;

@Transactional
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
