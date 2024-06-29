package com.dashboard.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.dashboard.model.Company;

public interface CompanyService {
	public List<Company> getData();
	public void saveFileV2();
	public List<Object> getDataBy(String filterName, String filter);
}
