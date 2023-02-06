package com.ArabSoft.StagePfe.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArabSoft.StagePfe.Models.NotreServices;

@Repository
public interface NotreServicesRepository extends JpaRepository<NotreServices, Long> {

}
