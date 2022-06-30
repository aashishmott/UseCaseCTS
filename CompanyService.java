package com.trade.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.entity.Company;
import com.trade.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository tradeRepo;
	
	public String createCompanyDetails(Company companyEntity){
		  
		  companyEntity = tradeRepo.save(companyEntity);
		  return String.valueOf(companyEntity.getCompanyCode());
		
	}
	
	
	public Company searchCompanyDetails(String companyCode){
		  return tradeRepo.findCompanyDetailsByCompanyCode(companyCode);
		
	}
	
	public List<Company> searchAllCompanyDetails(){
		 return tradeRepo.findAll();
	}


	public void removeCompanyDetails(int companyId) {
		// TODO Auto-generated method stub
		 tradeRepo.deleteById(companyId);
		
	}
	
	
	
	

}
