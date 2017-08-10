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
 * @author RENT
 */
@ManagedBean(name = "changeClientBean")
@SessionScoped
public class ChangeClientBean {

    private Client client;

    public Client getClient() {
        return client;
    }

    public String setClient(Client client) {
        this.client = client;
        return "changeclient.xhtml";
    }

    public String save() {
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
        return "showclients.xhtml";
    }

}
