package com.ArabSoft.StagePfe.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArabSoft.StagePfe.Models.Congee;

@Repository
public interface CongeeRepository extends JpaRepository<Congee, Long>{

}
