/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.komissamochodowy.controller;

import com.mycompany.komissamochodowy.Dto.*;
import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import java.util.*;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;



/**
 *
 * @author RENT
 */
@ManagedBean(name = "carManagedBean")
@ApplicationScoped
public class CarManagedBean {

    CarDto carDto = new CarDto();

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }
     

    public void addCar()
    {
        SessionFactory instance = ConfigHibernate.getInstance();            
        Session session = instance.openSession();            
        Transaction beginTransaction = session.beginTransaction();
    
        //TO DO - przerob DTO na Entity Car i zapisz do BD
        
        try {
            
            Car car = new Car();
            car = (Car)getMappedObject(carDto, new Car());
            session.save(car);
            
        } catch (Exception e) {
            System.out.println(e);
            beginTransaction.rollback();
        }
        beginTransaction.commit(); 
        
    }
    
    public void deleteCar()
    {
        SessionFactory instance = ConfigHibernate.getInstance();            
        Session session = instance.openSession();            
        Transaction beginTransaction = session.beginTransaction();
    
        try {
            Query query = session.createQuery("From Car Where id=:id").setParameter("id", carDto.getId());
            Optional<Car> car = query.list().stream().findFirst();
            
            if(car.isPresent())
            {
                session.delete(car.get());
            }            
            
        } catch (Exception e) {
            System.out.println(e);
            beginTransaction.rollback();
        }
        beginTransaction.commit();
    }
    
    public void updateCar()
    {
        SessionFactory instance = ConfigHibernate.getInstance();            
        Session session = instance.openSession();            
        Transaction beginTransaction = session.beginTransaction();
    
        try {
            Query query = session.createQuery("From Car Where id=:id").setParameter("id", carDto.getId());
            Optional<Car> car = query.list().stream().findFirst();
            
            if(car.isPresent())
            {
                session.merge(car.get());
            }            
            
        } catch (Exception e) {
            System.out.println(e);
            beginTransaction.rollback();
        }
        beginTransaction.commit();
    }
    
    
    public List<CarDto> getCars()
    {        
        SessionFactory instance = ConfigHibernate.getInstance();            
        Session session = instance.openSession();            
        Transaction beginTransaction = session.beginTransaction();
        
        Query query = session.createQuery("From Car");
        List<Car> cars = query.list();
        List<CarDto> carsDto = new ArrayList<CarDto>() {};

        if(cars.size()>0)
        {
            for(Car c : cars)
            {
                CarDto carDto = (CarDto)getMappedObject(c, new CarDto());
                carsDto.add(carDto);
            }
        
        }

        
        return carsDto;
    }
    
    
    private Object getMappedObject(Object start, Object destination) {
        ModelMapper mapper = new ModelMapper();
        Object map = mapper.map(start, destination.getClass());
        return map;
    }
    
    
}
