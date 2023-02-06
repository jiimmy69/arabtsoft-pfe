package com.ArabSoft.StagePfe.Services;

import java.util.List;

import com.ArabSoft.StagePfe.Models.Authorization;

public interface AuthorizationService {
	
	public List<Authorization> getAllAuthorization();

	public Authorization addAuthorization(Authorization auth);

	public void deleteAuthorizationById(Long id);

	public Authorization editAuthorization(Authorization auth);

	public Authorization getAuthorizationById(Long id);
}
