package com.brs.investmentcalculator.model;

import lombok.Data;

@Data
public class InvestmentDetails {
    private int year;
    private int initialInvestment;
    private int yearlyInvestment;
    private int totalInvestment;
    private int interestEarn;
    private int totalInterest;
    private int endingBalance;
    
}
