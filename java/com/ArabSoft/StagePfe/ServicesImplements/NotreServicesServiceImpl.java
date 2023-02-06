package com.ArabSoft.StagePfe.ServicesImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArabSoft.StagePfe.Models.NotreServices;
import com.ArabSoft.StagePfe.Repositorys.NotreServicesRepository;
import com.ArabSoft.StagePfe.Services.NotreServicesService;

@Service
public class NotreServicesServiceImpl implements NotreServicesService{

	@Autowired
	NotreServicesRepository notreServicesRepository;
	
	@Override
	public List<NotreServices> getAllNotreServices() {
		// TODO Auto-generated method stub
		return (List<NotreServices>)notreServicesRepository.findAll() ;
	}

	@Override
	public NotreServices addNotreServices(NotreServices ns) {
		// TODO Auto-generated method stub
		return notreServicesRepository.save(ns);
	}

	@Override
	public void deleteNotreServicesById(Long id) {
		// TODO Auto-generated method stub
		notreServicesRepository.deleteById(id);
	}

	@Override
	public NotreServices editNotreServices(NotreServices ns) {
		// TODO Auto-generated method stub
		return notreServicesRepository.save(ns);
	}

	@Override
	public NotreServices getNotreServicesById(Long id) {
		// TODO Auto-generated method stub
		Optional<NotreServices> notreService = notreServicesRepository.findById(id);
		return notreService.isPresent()? notreService.get():null;
	}

}
