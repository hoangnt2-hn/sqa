package com.hoangnt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoangnt.entity.Account;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Modifying
	@Query("UPDATE Account a SET a.password=?1 where a.id=?2")
	void updatePassword(String password, int id);
}
