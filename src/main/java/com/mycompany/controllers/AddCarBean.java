/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import com.mycompany.komissamochodowy.model.FuelType;
import com.mycompany.komissamochodowy.model.TransmissionType;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Grzegorz
 */
@ManagedBean(name = "addCarBean")
@RequestScoped
public class AddCarBean {
    private String vin = "";
    
    private Integer productionYear = 0;
    
    private String brand = "";
    
    private String model = "";
   
    private Integer ocNumber = 0;
    
    private Integer registrationNumber = 0;
    
    private FuelType fuelType;
    
    private Long milage = 0L;
    
    private Integer power = 0;
 
    private TransmissionType transmission;
    
    private String description = "";
    
    private Integer testDrive = 0;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getOcNumber() {
        return ocNumber;
    }

    public void setOcNumber(Integer ocNumber) {
        this.ocNumber = ocNumber;
    }

    public Integer getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Integer registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Long getMilage() {
        return milage;
    }

    public void setMilage(Long milage) {
        this.milage = milage;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTestDrive() {
        return testDrive;
    }

    public void setTestDrive(Integer testDrive) {
        this.testDrive = testDrive;
    }
    
    public FuelType[] getFueltypes(){
        return FuelType.values();
    }
    
    public TransmissionType[] getTransmissionTypes(){
        return TransmissionType.values();
    }
    
    public String save(){
        Car c = new Car();
        
        c.setBrand(brand);
        c.setDescription(description);
        c.setFuelType(fuelType);
        c.setMilage(milage);
        c.setModel(model);
        c.setOcNumber(ocNumber);
        c.setPower(power);
        c.setProductionYear(productionYear);
        c.setRegistrationNumber(registrationNumber);
        c.setTransmission(transmission);
        c.setVin(vin);
        
        
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();
        return "showcars.xhtml";
    }
    
    
}
