package com.trade.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Trade_Data")

public class TradeDataEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tradeId;
	
	private int companyId;
	
	private float  stockPrice;
	
	private Date stockDate;
	
	private String companyCode;
	
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public float getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	
	public TradeDataEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TradeDataEntity [companyId=" + companyId + ", stockPrice=" + stockPrice + ", stokeDate="
				+ stockDate + ", companyCode=" + companyCode + "]";
	}
	public TradeDataEntity(int tradeId , int companyId, float stockPrice, Date stockDate, String companyCode) {
		super();
		this.tradeId = tradeId;
		this.companyId = companyId;
		this.stockPrice = stockPrice;
		this.stockDate = stockDate;
		this.companyCode = companyCode;
	}
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public Date getStockDate() {
		return stockDate;
	}
	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}
	
	
	
	
	

}
