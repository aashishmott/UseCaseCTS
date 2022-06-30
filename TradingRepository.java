package com.trade.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trade.entity.TradeDataEntity;

@Repository
public interface TradingRepository extends JpaRepository<TradeDataEntity, Integer> {

	@Query(value = "select trade.trade_id, trade.company_id, trade.company_code, trade.stock_date, trade.stock_price from Trade_Data trade where trade.company_code = ?1 and trade.stock_date >= ?2 and trade.stock_date <= ?3", nativeQuery = true)
	List<TradeDataEntity> findStockDetails(String companyCode, LocalDate startDate, LocalDate endDate);

	@Modifying
    @Transactional
	@Query(value = "delete from Trade_Data  where company_code = ?1 ", nativeQuery = true)
	void deleteStockDetailsForCompany(String companyCode);

	@Query(value = "select trade.stock_price from Trade_Data trade where trade.company_code = ?1 order by trade.stock_date desc limit 1", nativeQuery = true)
	Float findLatestStockPriceByCompanyCode(String companyCode);
	

}
