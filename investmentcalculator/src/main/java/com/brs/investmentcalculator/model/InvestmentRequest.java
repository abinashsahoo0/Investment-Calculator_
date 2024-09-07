package com.brs.investmentcalculator.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class InvestmentRequest {
    private int startingYear;
    private int intialInvestment;
    private int yearlyInvestment;
    private int investmentTerm;
    private int returnRate;
    private InterestMode interestMode;


    
}
