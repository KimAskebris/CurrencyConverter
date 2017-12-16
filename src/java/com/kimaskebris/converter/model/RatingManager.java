/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimaskebris.converter.model;

import javax.ejb.Stateless;

/**
 *
 * @author Kim
 */
@Stateless
public class RatingManager {
    
    
    public RatingManager() {
        
    }
    
    public Double calculateAmountInNewCurrency(Double amount, Rating rating) {
        return amount * rating.getRate();
    }
    
}
