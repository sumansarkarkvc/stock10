package com.backend.stock.repository;

import com.backend.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findAllByCompanyCodeAndCreatedDateBetween(String companyCode, LocalDate startDate, LocalDate endDate);

    void deleteByCompanyCode(String companyCode);

    List<Stock> findByCompanyCode(String companyCode);
}
