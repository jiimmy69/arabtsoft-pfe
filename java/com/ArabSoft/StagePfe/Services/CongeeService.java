package com.ArabSoft.StagePfe.Services;

import java.util.List;

import com.ArabSoft.StagePfe.Models.Congee;

public interface CongeeService {
	
	public List<Congee> getAllCongees();

	public Congee addCongee(Congee c);

	public void deleteCongeeById(Long id);

	public Congee editCongee(Congee c);

	public Congee getCongeeById(Long id);

}
