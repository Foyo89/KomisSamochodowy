/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Grzegorz
 */
@ManagedBean(name = "changeCarBean")
@SessionScoped
public class ChangeCarBean {
    
    private Car car;

    public Car getCar() {
        return car;
    }
    
    
    
    public String setCar(Car car) {
        
        this.car = car;
        return "changecar.xhtml";
    }
    
    public String save(){
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(car);
        transaction.commit();
        return "showcars.xhtml";
    }
    
    
    
    
}
