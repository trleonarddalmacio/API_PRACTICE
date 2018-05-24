package com.leodalmacio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leodalmacio.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	// Normal
	Page<User> findByFNameContainingOrLNameContainingOrEmailContainingOrAddressContaining(String search, String search2, String search3, String search4, Pageable pageable);
	Page<User> findById(Long id, Pageable pageable);
	Page<User> findByFNameContaining(String fName, Pageable pageable);
	Page<User> findByLNameContaining(String lName, Pageable pageable);
	Page<User> findByEmailContaining(String email, Pageable pageable);
	Page<User> findByAddressContaining(String address, Pageable pageable);
}