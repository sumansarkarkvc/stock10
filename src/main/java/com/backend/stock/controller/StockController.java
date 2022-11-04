package com.backend.stock.controller;

import com.backend.stock.entity.Stock;
import com.backend.stock.repository.StockRepository;
import com.backend.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/v1.0/market/stock")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @PostMapping("/add/{companyCode}")
    public Stock saveStock(@Valid @RequestBody Stock stock, @PathVariable("companyCode") String companyCode) {
        return stockService.saveStock(stock, companyCode);
    }

    @GetMapping("/getStocks")
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @GetMapping("/get/{companyCode}/{startDate}/{endDate}")
    public List<Stock> getStockWithCompanyCodeWithinTimeSpan(@PathVariable("companyCode") String companyCode, @PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
        return stockService.getStockWithCompanyCodeWithinTimeSpan(companyCode, startDate, endDate);
    }

    @GetMapping("/info/{companyCode}")
    public List<Stock> findStockByCompanyCode(@PathVariable("companyCode") String companyCode) {
        return stockService.findStockByCompanyCode(companyCode);
    }

    @DeleteMapping("/delete/{companyCode}")
    public String deleteStock(@PathVariable("companyCode") String companyCode) {
        stockService.deleteStock(companyCode);
        return "Stock data is deleted";
    }

}
