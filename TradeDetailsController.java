package com.trade.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trade.entity.Company;
import com.trade.entity.TradeDataEntity;
import com.trade.service.CompanyService;
import com.trade.service.TradingService;

@RestController
@RequestMapping("api/v1.0/market/stock")
public class TradeDetailsController {
	
	@Autowired
	TradingService tradeService;
	
	@Autowired
	CompanyService compService;
	
	@RequestMapping(path ="/add/{companyCode}" , method = RequestMethod.POST,  consumes = "application/json")
	public String addStockPriceForCompany(@PathVariable String companyCode , @RequestBody TradeDataEntity trade) {
		
		String msg="";
		int tradeId;
		Company company = compService.searchCompanyDetails(companyCode);
		if(null!=company) {
			trade.setCompanyId(company.getCompanyId());
			trade.setCompanyCode(company.getCompanyCode());
			
			 tradeId = tradeService.addStockPriceForCompany(trade);
			 msg= "Stock added for companyCode : "+companyCode;
			
		}
		else {
			msg = "Provide valid Company code to add stock.";
		}
			 return msg;
		
	}
	
	@RequestMapping(path ="/get/{companyCode}/{startDate}/{endDate}" , method = RequestMethod.GET, produces = "application/json")
	public List<TradeDataEntity> getStockDetails(@PathVariable String companyCode, @PathVariable  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			   @PathVariable  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

		System.out.println("Method to get Stock details");
		
		// Call service to fetch stockDetails for companyCode
		Company company = compService.searchCompanyDetails(companyCode);
		if(null!=company) {
			 return tradeService.findStockDetailsForCompany(companyCode, startDate, endDate);
			
		}
		    return null;
		
	}

}
