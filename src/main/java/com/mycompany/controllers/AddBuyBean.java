/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;


import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Buy;
import com.mycompany.komissamochodowy.model.Car;
import com.mycompany.komissamochodowy.model.Client;
import java.math.BigDecimal;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author RENT
 */
@ManagedBean(name = "addBuyBean")
@RequestScoped
public class AddBuyBean {
    
    
    private Client client;
    private Car car;
    private String text;
    private Date date;
    private BigDecimal amount;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public String save(){
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        
        Buy buy = new Buy();
        buy.setCar(car);
        buy.setClient(client);
        buy.setAmount(amount);
        buy.setDate(date);
        buy.setText(text);
        
        Transaction transaction = session.beginTransaction();
        session.save(buy);
        transaction.commit();
        return "showcars.xhtml";
    }
    
    
    
    
}
