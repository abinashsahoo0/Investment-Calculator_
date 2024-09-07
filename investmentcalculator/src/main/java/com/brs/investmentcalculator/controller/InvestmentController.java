package com.brs.investmentcalculator.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.brs.investmentcalculator.model.InvestmentRequest;
import com.brs.investmentcalculator.service.InvestmentService;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class InvestmentController{
    private final InvestmentService service;
    @GetMapping
    public String home() {
        return "index";
    }
    @PostMapping("/calculate")
    public String calculate(@ModelAttribute InvestmentRequest request, Model model){
        model.addAttribute("response",service.calculate(request));

       
        return "index";
    }

}
