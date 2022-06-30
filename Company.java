package com.trade.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Company")
public class Company implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int companyId;
	
	private String companyCode;
	private String companyName;
	private String ceo;
	private double turnover;
	private String companyWebsite;
	private String stockEnlisted;
	
	
	public Company(int companyId, String companyCode, String companyName, String companyCeo, double turnover,
			String companyWebsite, String stockEnlisted) {
		super();
		this.companyId = companyId;
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.ceo = companyCeo;
		this.turnover = turnover;
		this.companyWebsite = companyWebsite;
		this.stockEnlisted = stockEnlisted;
	}


	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public String getCompanyCode() {
		return companyCode;
	}


	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyCeo() {
		return ceo;
	}


	public void setCompanyCeo(String companyCeo) {
		this.ceo = companyCeo;
	}


	public double getTurnover() {
		return turnover;
	}


	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}


	public String getCompanyWebsite() {
		return companyWebsite;
	}


	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}


	public String getStockEnlisted() {
		return stockEnlisted;
	}


	public void setStockEnlisted(String stockEnlisted) {
		this.stockEnlisted = stockEnlisted;
	}


	@Override
	public String toString() {
		return "CompanyEntity [companyId=" + companyId + ", companyCode=" + companyCode + ", companyName=" + companyName
				+ ", companyCeo=" + ceo + ", turnover=" + turnover + ", companyWebsite=" + companyWebsite
				+ ", stockEnlisted=" + stockEnlisted + "]";
	}
	
	public Company() {
		super();
		// Auto Generated Constructor stub
	}
	



}



