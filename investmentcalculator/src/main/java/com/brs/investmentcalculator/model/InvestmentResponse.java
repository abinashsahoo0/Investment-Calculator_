package com.brs.investmentcalculator.model;
import java.util.List;

import lombok.Data;

@Data
public class InvestmentResponse {
   private InterestMode interestMode;
    private int totalInvestment;
    private int totalReturn;
    private List<InvestmentDetails> details;
}
