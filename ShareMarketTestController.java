package com.trade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trade.dto.ResponseDto;
import com.trade.entity.Company;
import com.trade.exceptions.TradeExceptions;
import com.trade.service.CompanyService;
import com.trade.service.TradingService;

@RestController
@RequestMapping("api/v1.0/market/company")
public class ShareMarketTestController {



	@Autowired
	CompanyService companyService;

	@Autowired
	TradingService tradeService;

	@Autowired
	ResponseDto responseDto;

	@RequestMapping(path ="/register" , method = RequestMethod.POST,  consumes = "application/json")
	public String registerCompany(@RequestBody Company company) throws TradeExceptions {
		System.out.println("Inside comapny registration method");
		String msg="";
		msg = validateCompanyDetails(company);

		if(!msg.contains("Error"))
			msg = validateCompanyCode(company);

		System.out.println("Error message after creating data "+msg );

		if(msg.contains("Error : ")) {
			throw new TradeExceptions(msg);
		}

		// Call service/repo to store the Stock data into database.
		return companyService.createCompanyDetails(company);
	}


	@RequestMapping(path ="/info/companyCode/{companyCode}" , method = RequestMethod.GET, produces = "application/json")
	public ResponseDto getCompanyDetails(@PathVariable String companyCode) {

		System.out.println("Method to get company details");
		// Call service to fetch companyDetails
		Company company= companyService.searchCompanyDetails(companyCode);
		responseDto.setCompanyCeo(company.getCompanyCeo());
		responseDto.setCompanyCode(company.getCompanyCode());
		responseDto.setCompanyName(company.getCompanyName());
		responseDto.setTurnover(company.getTurnover());

		// to call latest stock price 

		responseDto.setLatestStockPrice(tradeService.getStockPrice(companyCode));
		return responseDto;
	}

	@RequestMapping(path ="/getall" , method = RequestMethod.GET, produces = "application/json")
	public List<ResponseDto> getAllCompanyDetails() {

		System.out.println("Method to get company details");
		List<ResponseDto> responseDtos = new ArrayList<ResponseDto>();
		// Call service to fetch companyDetails
		List<Company> companyList= companyService.searchAllCompanyDetails();
		for(Company company : companyList) {
			ResponseDto responseDto = new ResponseDto();


			String companycode = company.getCompanyCode();
			float value = tradeService.getStockPrice(companycode);
			System.out.println("Stock Price :"+  value +" For companyCode: "+companycode);
			if( 0 != value) {
				responseDto.setCompanyCeo(company.getCompanyCeo());
				responseDto.setCompanyCode(company.getCompanyCode());
				responseDto.setCompanyName(company.getCompanyName());
				responseDto.setTurnover(company.getTurnover());
				responseDto.setLatestStockPrice(tradeService.getStockPrice(companycode));
				responseDtos.add(responseDto);
			}

		}

		return responseDtos;

	}

	@RequestMapping(path ="/delete/{companyCode}" , method = RequestMethod.DELETE)
	public String removeCompany(@PathVariable String companyCode) throws TradeExceptions {

		System.out.println("Method to remove company from database");
		String msg= "";
		int companyId = 0;
		if(null!= companyService.searchCompanyDetails(companyCode)) {
			companyId= companyService.searchCompanyDetails(companyCode).getCompanyId();
		}
		if(companyId!=0) {
			tradeService.deleteStockDetailsForCompany(companyCode);
			companyService.removeCompanyDetails(companyId);
			msg = "Company Details Deleted.";
		}
		else {
			msg  = "Company code not found in database.";
			throw new TradeExceptions(msg);
		}

		return msg;
	}

	private String validateCompanyDetails(Company company) {
		// TODO Auto-generated method stub
		String msg="Success";
		if(null == company.getCompanyCode() || "".equals(company.getCompanyCode()))
			msg="Error : Company code is mandatory";
		else if(null == company.getCompanyCeo() || "".equals(company.getCompanyCeo()))
			msg="Error : Company CEO is mandatory";
		else if(null == company.getCompanyName() || "".equals(company.getCompanyName()))
			msg="Error : Company Name is mandatory";
		else if(null == company.getCompanyWebsite() || "".equals(company.getCompanyWebsite()))
			msg="Error : Company Website is mandatory";
		else if(null == company.getStockEnlisted() || "".equals(company.getStockEnlisted()))
			msg="Error : Company Enlisted is mandatory (NSE/BSE)";
		else if(0 == company.getTurnover() )
			msg="Error : Company Turnover is mandatory";

		if(company.getTurnover() < 100000000)
			msg = "Error : Company turnover should be greater than 10CR.";

		return msg;
	}

	private String validateCompanyCode(Company company) {
		// TODO Auto-generated method stub
		String msg="Success";
		String companyCode = "";
		System.out.println("Inside validating company code: code from user input "+company.getCompanyCode());
		if(null != company.getCompanyCode()) {
			if(null!=companyService.searchCompanyDetails(company.getCompanyCode()))
				companyCode = companyService.searchCompanyDetails(company.getCompanyCode()).getCompanyCode();

			System.out.println("Company code from database" +companyCode);

			if(null!= companyCode && companyCode.equalsIgnoreCase(company.getCompanyCode()) )
				msg = "Error : Company code should be unique";
		}

		return msg;
	}
}
