/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.komissamochodowy.converter;

import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Client;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author RENT
 */
@ManagedBean(name = "clientConverterBean")
@FacesConverter("clientConverter")
public class ClientConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        Long id = Long.valueOf(value);
        Client uniqueResult = (Client) session.createQuery("FROM Client WHERE id=:clientID")
                .setParameter("clientID", id)
                .uniqueResult();
        
        
        return uniqueResult;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Client c = (Client) value;
        String s = c.getId().toString();
        return s;
    }
    
}
