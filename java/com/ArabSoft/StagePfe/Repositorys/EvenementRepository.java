package com.ArabSoft.StagePfe.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArabSoft.StagePfe.Models.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long>{

}
