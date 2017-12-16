/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimaskebris.converter.view;


import com.kimaskebris.converter.controller.ConvertController;
import com.kimaskebris.converter.model.Rating;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Kim
 */
@Named("ConverterManager")
@RequestScoped
public class ConverterManager implements Serializable {
   
   @EJB
    private ConvertController convertController;
    private Double amountToConvert;
    private String fromCurrency;
    private String toCurrency;
    private Double amountInNewCurrency;
    
            
    public ConverterManager() {
        
    }

    public Double getAmountToConvert() {
        return amountToConvert;
    }

    public void setAmountToConvert(Double amountToConvert) {
        this.amountToConvert = amountToConvert;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }
    
     public Double getAmountInNewCurrency() {
        return amountInNewCurrency;
    }

    public void setAmountInNewCurrency(Double amountInNewCurrency) {
        this.amountInNewCurrency = amountInNewCurrency;
    }
    
    public void calculate() {
        amountInNewCurrency = convertController.convert(amountToConvert, fromCurrency, toCurrency);
    }

   

    

    
   
    
    
    
}
