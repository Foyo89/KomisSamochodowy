/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import com.mycompany.komissamochodowy.model.Client;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author RENT
 */

@ManagedBean(name = "showClientsBean")
@RequestScoped
public class ShowClientsBean {
    
    public List<Client> getList(){
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        
        List <Client> clients = session.createQuery("FROM Client")
        .list();
        
        return clients;
        
    }
    
}
