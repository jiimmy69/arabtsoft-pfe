package com.ArabSoft.StagePfe.ServicesImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArabSoft.StagePfe.Models.Authorization;
import com.ArabSoft.StagePfe.Repositorys.AuthorizationRepository;
import com.ArabSoft.StagePfe.Services.AuthorizationService;


@Service
public class AuthorizationServiceImpl implements AuthorizationService{

	@Autowired
	AuthorizationRepository authorizationRepository;
	
	@Override
	public List<Authorization> getAllAuthorization() {
		// TODO Auto-generated method stub
		return (List<Authorization>) authorizationRepository.findAll();
	}

	@Override
	public Authorization addAuthorization(Authorization auth) {
		// TODO Auto-generated method stub
		return authorizationRepository.save(auth);
	}

	@Override
	public void deleteAuthorizationById(Long id) {
		// TODO Auto-generated method stub
		authorizationRepository.deleteById(id);
	}

	@Override
	public Authorization editAuthorization(Authorization auth) {
		// TODO Auto-generated method stub
		return authorizationRepository.save(auth);
	}

	@Override
	public Authorization getAuthorizationById(Long id) {
		// TODO Auto-generated method stub
		Optional<Authorization> authorization = authorizationRepository.findById(id);
		return authorization.isPresent()?authorization.get():null;
	}

}
