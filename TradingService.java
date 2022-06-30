package com.trade.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.entity.TradeDataEntity;
import com.trade.repository.TradingRepository;

@Service
public class TradingService {


	@Autowired
	TradingRepository tradeRepo;

	public int addStockPriceForCompany(TradeDataEntity trade) {
		// TODO Auto-generated method stub
		tradeRepo.save(trade);

		return trade.getTradeId();
	}

	public List<TradeDataEntity> findStockDetailsForCompany(String companyCode , LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return tradeRepo.findStockDetails(companyCode, startDate, endDate);
	}

	public void deleteStockDetailsForCompany(String companyCode) {

		tradeRepo.deleteStockDetailsForCompany(companyCode);
	}

	public Float getStockPrice(String companyCode) {
		Float value = tradeRepo.findLatestStockPriceByCompanyCode(companyCode);

		if(null == value)
			value = (float) 0;
		return value;
	}


}
