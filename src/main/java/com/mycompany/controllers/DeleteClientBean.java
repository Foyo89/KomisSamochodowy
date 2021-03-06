/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Client;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Grzegorz
 */
@ManagedBean(name = "deleteClientBean")
@SessionScoped
public class DeleteClientBean {
    
    
    public String deleteClient(Client client){
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(client);
        transaction.commit();
        return "showclients.xhtml";
    }
}
