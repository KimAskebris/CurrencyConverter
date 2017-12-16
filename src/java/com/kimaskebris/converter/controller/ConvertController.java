/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimaskebris.converter.controller;


import com.kimaskebris.converter.integration.CurrencyDAO;
import com.kimaskebris.converter.model.Rating;
import com.kimaskebris.converter.model.RatingManager;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Kim
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class ConvertController {
    
    @EJB
    private CurrencyDAO currencyDAO;
    @EJB
    private RatingManager ratingManager;

    public ConvertController() {
    }
    
    public Double convert(Double amount, String fromCurrency, String toCurrency) {
        Rating rating = currencyDAO.getConvertRate(fromCurrency, toCurrency);
        Double newAmount = ratingManager.calculateAmountInNewCurrency(amount, rating);
        //Rounds to max two decimals .00
        return (double) Math.round(newAmount * 100) / 100;
    }
    
}
