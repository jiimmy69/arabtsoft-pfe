package com.ArabSoft.StagePfe.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArabSoft.StagePfe.Models.Authorization;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

}
