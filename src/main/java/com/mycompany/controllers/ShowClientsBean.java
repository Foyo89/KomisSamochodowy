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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author RENT
 */

@ManagedBean(name = "showClientsBean")
@RequestScoped
public class ShowClientsBean {
    
    private String filterType;
    private String filterValue;
    
    private SessionFactory instance = ConfigHibernate.getInstance();
    private Session session = instance.openSession();

    public String getFilterType() {
        return filterType;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }
    
    
    
    public List<Client> getList(){
      
        Query query = getQuery();
        
        List <Client> clients = query.list();

        return clients; 
    }
    
    public Query getQuery()
    {
        Query query;
        
        if(filterType == null || filterValue == null)
        {   
            query = session.createQuery("FROM Client");
        }
        else
        {
            if(filterType.equals("brak"))
            {
                query = session.createQuery("FROM Client");
            }
            else
            {
                query = session.createQuery("FROM Client as c where c."+ filterType + " like ?")
                        .setString(0, "%"+filterValue+"%"); 
            }
        
        }
        
        return query;
    }
    
    public String filter()
    {
    
        return "showclients.xhtml";
    }
}
