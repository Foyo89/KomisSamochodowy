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
 * @author Grzegorz
 */
@ManagedBean(name = "addContractBean")
@RequestScoped
public class AddContractBean {
    
    private Client client;
    private Car car;
    private String text;
    private Date date;
    private BigDecimal amount;
    
    private SessionFactory instance = ConfigHibernate.getInstance();
    private Session session = instance.openSession();

    public Client getClient() {
        return client;
    }

    public void setClient(String client) {
        Client cl = (Client)session.createQuery("FROM Client WHERE id=:clientID")
                .setParameter("clientID", client)
                .uniqueResult();
        this.client = cl;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(String car) {
        Car c = (Car)session.createQuery("FROM Car WHERE id=:carID")
                .setParameter("carID", car)
                .uniqueResult();
        
        this.car = c;
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
    
    
    public void save(){
        Buy buy = new Buy();
        
        buy.setClient(client);
        buy.setCar(car);
        buy.setAmount(amount);
        buy.setDate(date);
        buy.setText(text);
        
        
        Transaction transaction = session.beginTransaction();
        session.save(buy);
        transaction.commit();
               
    }
    
    
    
    
}
