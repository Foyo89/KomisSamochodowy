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
import com.mycompany.komissamochodowy.model.Contract;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
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
    
    private Car car;
    private Client client;
    private String text;    
    private Date date;
    private BigDecimal amount;
    private SessionFactory instance = ConfigHibernate.getInstance();
    private Session session = instance.openSession();
    
    private String carId;
    private String clientId;
    
    public Car getCar() {
        return car;
    }

    public void setCarId(String carId) {
        this.carId = carId;
        Car c = (Car)session.createQuery("FROM Car WHERE id=:carID")
                .setParameter("carID", carId )
                .uniqueResult();
        //setCar(c);
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
         Car c = (Car)session.createQuery("FROM Car WHERE id=:carID")
                .setParameter("carID", carId )
                .uniqueResult();
        //setCar(c);
    }
    
    
    
    
    public void setCar(String car) {
        Car c = (Car)session.createQuery("FROM Car WHERE id=:carID")
                .setParameter("carID", car )
                .uniqueResult();
        this.car = c;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(String client) {             
        Client c = (Client)session.createQuery("FROM Client WHERE id=:carID")
                .setParameter("carID", client )
                .uniqueResult();
        this.client = c;
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
 
        buy.setCar(car);
        buy.setClient(client);
        buy.setText(text);
        buy.setAmount(amount);
        buy.setDate(date);
        
        instance = ConfigHibernate.getInstance();
        session = instance.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(buy);
        transaction.commit();
        
    }
    
    public List<Car> getCarList() {
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();

        List<Car> cars = session.createQuery("FROM Car")
                .list();
        return cars;

    }
    public List<Client> getClientList() {
        instance = ConfigHibernate.getInstance();
        session = instance.openSession();

        List<Client> clients = session.createQuery("FROM Client")
                .list();
        return clients;
    }
    public List<Contract> getContractList() {
        instance = ConfigHibernate.getInstance();
        session = instance.openSession();

        List<Contract> contracts = session.createQuery("FROM Buy")
                .list();
        return contracts;

    }
}
