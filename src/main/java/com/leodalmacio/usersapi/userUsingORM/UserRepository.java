package com.leodalmacio.usersapi.userUsingORM;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByFNameContainingOrLNameContainingOrEmailContainingOrAddressContaining(String search, String search2, String search3, String search4);
}
