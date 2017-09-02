/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Grzegorz
 */
@ManagedBean(name = "showCarsBean")
@RequestScoped
public class ShowCarsBean {
    private int pageSize = 5;
    private int page = 0;
    private List<Car> cars;
    
    private boolean pagination = false;
    private boolean previousPageControl;
    private boolean nextPageControl;

    private SessionFactory instance = ConfigHibernate.getInstance();
    private Session session = instance.openSession();

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    
    
    public boolean isPagination() {
        return pagination;
    }

    public void setPagination(boolean pagination) {
        this.pagination = pagination;
    }

    public boolean isPreviousPageControl() {
        if (pagination && page>0)
            previousPageControl = true;
        else previousPageControl = false;
        return previousPageControl;
    }

    public boolean isNextPageControl() {
        if (pagination && page+page<cars.size())
            nextPageControl = true;
        else nextPageControl = false;
        return nextPageControl;
    }


    
    private void setCars(){
           

            cars = session.createQuery("FROM Car")
            .list();
            if (cars.size() > pageSize) pagination = true;
            
            
    }
    
    
    public List<Car> getList(){
        this.setCars();
        
        if(pagination){        
            
                
            
            return session.createQuery("FROM Car ")
                    .setMaxResults(pageSize)
                    .setFirstResult(page)
                    .list();
            
        }
        else{
            return cars;
        }

    }
    
    public void nextPage(){
        page = page+pageSize;
    }
    
    public void previousPage(){
        page = page-pageSize;
    }
    
    
    
    
    
    
   

}