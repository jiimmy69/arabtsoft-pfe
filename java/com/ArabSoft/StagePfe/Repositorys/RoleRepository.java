package com.ArabSoft.StagePfe.Repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArabSoft.StagePfe.Models.ERole;
import com.ArabSoft.StagePfe.Models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
