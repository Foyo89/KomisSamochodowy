/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.Dtos.CarDto;
import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Grzegorz
 */
@ManagedBean(name = "changeCarBean")
@SessionScoped
public class ChangeCarBean {
    
    private Car car;

    public Car getCar() {
        return car;
    }
    
    
    
    public String setCar(CarDto carDto) {
        
        Car car = carToCarDto(carDto);
        this.car = car;
        return "changecar.xhtml";
    }
    
    public String save(){
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(car);
        transaction.commit();
        return "showcars.xhtml";
    }
    
    public Car carToCarDto(CarDto carDto)
    {
        Car newCar = new Car();
        
        newCar.setBrand(carDto.getBrand());
        newCar.setDescription(carDto.getDescription());
        newCar.setFuelType(carDto.getFuelType());
        newCar.setId(carDto.getId());
        newCar.setMilage(carDto.getMilage());
        newCar.setModel(carDto.getModel());
        newCar.setOcNumber(carDto.getOcNumber());
        newCar.setPower(carDto.getPower());
        newCar.setProductionYear(carDto.getProductionYear());
        newCar.setRegistrationNumber(carDto.getRegistrationNumber());       
        newCar.setTestDrive(carDto.getTestDrive());       
        newCar.setTransmission(carDto.getTransmission());       
        newCar.setVin(carDto.getVin());       
        
        return newCar;
    
    }   
    
    
}
