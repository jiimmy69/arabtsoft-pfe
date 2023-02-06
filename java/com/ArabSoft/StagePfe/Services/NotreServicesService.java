package com.ArabSoft.StagePfe.Services;

import java.util.List;

import com.ArabSoft.StagePfe.Models.NotreServices;

public interface NotreServicesService {
	public List<NotreServices> getAllNotreServices();

	public NotreServices addNotreServices(NotreServices ns);

	public void deleteNotreServicesById(Long id);

	public NotreServices editNotreServices(NotreServices ns);

	public NotreServices getNotreServicesById(Long id);
}
