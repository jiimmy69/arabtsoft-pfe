package com.ArabSoft.StagePfe.Repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ArabSoft.StagePfe.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Boolean existsByEmail(String email);
	Boolean existsByTelephoneNumber(String telephoneNumber);
	Optional<User> findByEmail(String email);
}