/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimaskebris.converter.integration;

import com.kimaskebris.converter.model.Rating;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Kim
 */
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class CurrencyDAO {
    
    
    private Session session;
    
    public CurrencyDAO() {
    }
    
    public Rating getConvertRate(String fromCurrency, String toCurrency) {
        return findRateByNames(fromCurrency, toCurrency);
    }
    
    private Rating findRateByNames(String from, String to) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Rating where fromcurrency='"+from+"' and tocurrency='"+to+"'");
        Rating rating = (Rating) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return rating;
    }
    
}
