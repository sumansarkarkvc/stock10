package com.backend.stock.service;

import com.backend.stock.entity.Stock;
import com.backend.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock saveStock(Stock stock, String companyCode) {

        stock.setCompanyCode(companyCode);
        stock.setCreatedDate(LocalDate.now());
        return stockRepository.save(stock);
    }

    public List<Stock> getStockWithCompanyCodeWithinTimeSpan(String companyCode, String startDate, String endDate) {

        LocalDate dateStart = LocalDate.parse(startDate);
        LocalDate dateEnd = LocalDate.parse(endDate);

        return stockRepository.findAllByCompanyCodeAndCreatedDateBetween(companyCode, dateStart, dateEnd);
    }

    public List<Stock> findStockByCompanyCode(String companyCode) {
        return stockRepository.findByCompanyCode(companyCode);
    }

    public void deleteStock(String companyCode) {
        stockRepository.deleteByCompanyCode(companyCode);
    }
}
