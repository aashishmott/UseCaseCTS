package com.trade.dto;

import org.springframework.stereotype.Component;

@Component
public class ResponseDto {

	private String companyCode ;
	private String companyCeo;
	private String companyName;
	private float latestStockPrice;
	private double turnover;
	
	
	public double getTurnover() {
		return turnover;
	}
	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyCeo() {
		return companyCeo;
	}
	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	public float getLatestStockPrice() {
		return latestStockPrice;
	}
	public void setLatestStockPrice(float latestStockPrice) {
		this.latestStockPrice = latestStockPrice;
	}
	public ResponseDto(String companyCode, String companyCeo, String companyName, float latestStockPrice, double turnover) {
		super();
		this.companyCode = companyCode;
		this.companyCeo = companyCeo;
		this.companyName = companyName;
		this.latestStockPrice = latestStockPrice;
		this.turnover = turnover;
	}
	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseDto [companyCode=" + companyCode + ", companyCeo=" + companyCeo + ", companyName=" + companyName
				+ ", latestStockPrice=" + latestStockPrice + "]";
	}
	
	
	
	
}
