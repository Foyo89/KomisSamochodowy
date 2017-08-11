/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.komissamochodowy.converter;

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
 * @author RENT
 */
@ManagedBean(name = "carConverterBean")
@FacesConverter("com.mycompany.komissamochodowy.converter.CarConverter")
public class CarConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        Car uniqueResult = (Car) session.createQuery("FROM Car WHERE id=carID")
                .setParameter("carID", value)
                .uniqueResult();
        return uniqueResult;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return null;
    }
    
    
}
