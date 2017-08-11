/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.Dtos.CarDto;
import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author RENT
 */
@ManagedBean(name = "deleteCarBean")
@RequestScoped
public class DeleteCarBean {
        
        public String deleteCar(CarDto car){
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        
        Car temp = (Car) session.createQuery("FROM Car Where id=:carId")
                .setParameter("carId", car.getId())
                .uniqueResult();
                
        
        Transaction transaction = session.beginTransaction();
        session.delete(temp);
        transaction.commit();
        return "showcars.xhtml";
    }
    
}