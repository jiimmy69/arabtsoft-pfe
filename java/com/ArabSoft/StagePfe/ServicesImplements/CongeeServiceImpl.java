package com.ArabSoft.StagePfe.ServicesImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArabSoft.StagePfe.Models.Congee;
import com.ArabSoft.StagePfe.Repositorys.CongeeRepository;
import com.ArabSoft.StagePfe.Services.CongeeService;


@Service
public class CongeeServiceImpl implements CongeeService {

	@Autowired
	CongeeRepository congeeRepository;	
	@Override
	public List<Congee> getAllCongees() {
		// TODO Auto-generated method stub
		return (List<Congee>) congeeRepository.findAll();
	}

	@Override
	public Congee addCongee(Congee c) {
		// TODO Auto-generated method stub
		return congeeRepository.save(c);
	}

	@Override
	public void deleteCongeeById(Long id) {
		// TODO Auto-generated method stub
		congeeRepository.deleteById(id);
	}

	@Override
	public Congee editCongee(Congee c) {
		// TODO Auto-generated method stub
		return congeeRepository.save(c);
	}

	@Override
	public Congee getCongeeById(Long id) {
		// TODO Auto-generated method stub
		Optional<Congee> congee = congeeRepository.findById(id);
		return congee.isPresent()?congee.get():null;
	}

}
