package com.brs.investmentcalculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brs.investmentcalculator.model.InterestMode;
import com.brs.investmentcalculator.model.InvestmentDetails;
import com.brs.investmentcalculator.model.InvestmentRequest;
import com.brs.investmentcalculator.model.InvestmentResponse;

@Service
public class InvestmentService {
    public InvestmentResponse calculate(InvestmentRequest request){
        var interestMode = request.getInterestMode();
       var details =  interestMode == InterestMode.SIMPLE ? simpleCalculation(request) : compoundCalculation(request);

       var response = new InvestmentResponse();
       response.setInterestMode(interestMode);
       response.setDetails(details);
       

    //    if (details != null && !details.isEmpty()){ 
    //     var latestDetails = details.get(details.size() - 1);
       
    //    }
    //     // Continue with your logic using latestDetails
    //  else {
    //     // Handle the case where details is empty or null
    //     System.out.println("Details list is empty or null");
    //     // You might throw an exception, return a default value, or handle it in some other way
    //     // throw new IllegalArgumentException("Details list cannot be empty or null.");
    

    //    //var latestDetails = details.get(details.size()-1);
    //  }
    //  response.setTotalInvestment(latestDetails.getTotalInvestment());
    //  response.setTotalReturn(latestDetails.getEndingBalance());
    //   return response;

    if (details != null && !details.isEmpty()) {
        var latestDetails = details.get(details.size() - 1); // Get the last element
    
        // Set the response fields using latestDetails
        response.setTotalInvestment(latestDetails.getTotalInvestment());
        response.setTotalReturn(latestDetails.getEndingBalance());
    
        return response; // Return the populated response object
    } else {
        // Handle the case where 'details' is empty or null
        System.out.println("Details list is empty or null");
        // You could either throw an exception, return a default response, or handle it accordingly
        // throw new IllegalArgumentException("Details list cannot be empty or null.");
        return response; // or return a response with default or empty values
    }
    }

   

    private List<InvestmentDetails> simpleCalculation(InvestmentRequest request) {
        // TODO Auto-generated method stub
        var startingYear = request.getStartingYear();
        var initialInvestment = request.getIntialInvestment();
        var yearlyInvestment = request.getYearlyInvestment();
        var investmentTerm = request.getInvestmentTerm();
        var returnRate = request.getReturnRate();

        var endingBalance = initialInvestment;
        var totalInvestment = initialInvestment;
        var totalInterest = 0;

        var details = new ArrayList<InvestmentDetails>();
        for(int i=1;i<= investmentTerm;i++){
            var investmentDetails = new InvestmentDetails();
            investmentDetails.setYear(startingYear);
            investmentDetails.setInitialInvestment(initialInvestment);
            investmentDetails.setYearlyInvestment(yearlyInvestment);

            totalInvestment += yearlyInvestment;
            investmentDetails.setTotalInvestment(totalInvestment);

            int interestEarn = totalInvestment * returnRate / 100;
            investmentDetails.setInterestEarn(interestEarn);

            totalInterest += interestEarn;
            investmentDetails.setTotalInterest(totalInterest);

            endingBalance += yearlyInvestment + interestEarn;
            investmentDetails.setEndingBalance(endingBalance);

            details.add(investmentDetails);
            startingYear++;

            initialInvestment = endingBalance;



        }
        return details;
    }

    private List<InvestmentDetails> compoundCalculation(InvestmentRequest request) {
        // TODO Auto-generated method stub
        var startingYear = request.getStartingYear();
        var initialInvestment = request.getIntialInvestment();
        var yearlyInvestment = request.getYearlyInvestment();
        var investmentTerm = request.getInvestmentTerm();
        var returnRate = request.getReturnRate();

        var endingBalance = initialInvestment;
        var totalInvestment = initialInvestment;
        var totalInterest = 0;

        var details = new ArrayList<InvestmentDetails>();
        for(int i=1;i<= investmentTerm;i++){
            var investmentDetails = new InvestmentDetails();
            investmentDetails.setYear(startingYear);
            investmentDetails.setInitialInvestment(initialInvestment);
            investmentDetails.setYearlyInvestment(yearlyInvestment);

            totalInvestment += yearlyInvestment;
            investmentDetails.setTotalInvestment(totalInvestment);

            int interestEarn = endingBalance * returnRate / 100;
            investmentDetails.setInterestEarn(interestEarn);

            totalInterest += interestEarn;
            investmentDetails.setTotalInterest(totalInterest);

            endingBalance += yearlyInvestment + interestEarn;
            investmentDetails.setEndingBalance(endingBalance);

            details.add(investmentDetails);
            startingYear++;

            initialInvestment = endingBalance;
        }



        return details;
    }
    
    
}
