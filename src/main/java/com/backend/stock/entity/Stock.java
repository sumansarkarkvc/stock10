package com.backend.stock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockId;

    @Column(name = "stock_price")
    @DecimalMin(value = "0.0", inclusive = false, message = "Stock price must be greater than zero")
    private BigDecimal stockPrice;

    @Column(name = "stock_date")
    private LocalDate createdDate;

    @Column(name = "company_code")
    private String companyCode;
}
