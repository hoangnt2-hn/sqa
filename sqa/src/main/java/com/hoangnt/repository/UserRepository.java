package com.hoangnt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoangnt.entity.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Transactional
	@Query("SELECT u FROM User u WHERE u.account.username=?1 AND u.account.password=?2")
	public User login(String username, String password);

	@Transactional
	@Query("SELECT u FROM User u WHERE u.role.id like ?1")
	public List<User> finByRole(int role_id);
	
	@Transactional
	@Query("SELECT u FROM User u WHERE u.?1 like ?2")
	public User findByFull_name(String nameOrFullName,String full_name);
}