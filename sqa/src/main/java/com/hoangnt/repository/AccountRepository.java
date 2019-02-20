package com.hoangnt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangnt.entity.Account;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
