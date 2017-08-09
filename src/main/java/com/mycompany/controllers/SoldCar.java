/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import com.mycompany.komissamochodowy.model.Client;
import com.mycompany.komissamochodowy.model.Contract;
import com.mycompany.komissamochodowy.model.FuelType;
import com.mycompany.komissamochodowy.model.TransmissionType;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author RENT
 */
@ManagedBean(name = "soldCar")
@RequestScoped
public class SoldCar {
    
    private Contract contract;
    private Car car;
    

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    } 
    public String save() {
        Contract contract = new Contract();
        Car car = new Car();
        
        contract.getClient();
        contract.getCar();
        contract.getCar().setSoldCar(com.mycompany.komissamochodowy.model.SoldCar.SPRZEDANY);
        
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        Transaction transaction = session.beginTransaction();
        
  
        transaction.commit();
        return "soldcar.xhtml";
    }
    
    
    
}
