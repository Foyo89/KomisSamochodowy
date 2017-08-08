/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author RENT
 */
@ManagedBean(name = "newJSFManagedBean")
@ApplicationScoped
public class NewJSFManagedBean {
    
    

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {
    }
    
    public List<Car> getList(){
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        
        List <Car> cars = session.createQuery("FROM Car")
        .list();
        
        return cars;
        
    }
    
    
}
