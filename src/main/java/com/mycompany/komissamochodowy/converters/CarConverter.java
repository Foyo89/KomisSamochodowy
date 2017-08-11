/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.komissamochodowy.converters;

import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Grzegorz
 */
@ManagedBean(name = "carConverterBean") 
@FacesConverter(value = "carConverter")
public class CarConverter implements Converter{
    private SessionFactory instance = ConfigHibernate.getInstance();
    private Session session = instance.openSession();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return session.createQuery("FROM Car WHERE id=:carID")
                .setParameter("carID", value )
                .uniqueResult();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Car) value).getId().toString();
    }
    
}
