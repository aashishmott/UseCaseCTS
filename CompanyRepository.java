package com.trade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trade.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

		public Company findCompanyDetailsByCompanyCode(String companyCode);
		
		List<Company> findAll();
		
		
//		@Transactional
//		@Modifying
//		@Query("delete Company_Details where companyCode=?1")
//		public void deleteByCompanyCode(String companyCode);
       
	
	
}
