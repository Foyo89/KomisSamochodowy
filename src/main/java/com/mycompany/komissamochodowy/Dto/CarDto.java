/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.komissamochodowy.Dto;
import com.mycompany.komissamochodowy.model.FuelType;
import com.mycompany.komissamochodowy.model.TransmissionType;

/**
 *
 * @author RENT
 */
public class CarDto {
    private Long id;
    private String vin;
    private Integer productionYear;
    private String brand;
    private String model;
    private Integer ocNumber;
    private Integer registrationNumber;
    private FuelType fuelType;
    private Long milage;
    private Integer power;
    private TransmissionType transmission;
    private String description;
    private Integer testDrive;

    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getOcNumber() {
        return ocNumber;
    }

    public Integer getRegistrationNumber() {
        return registrationNumber;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public Long getMilage() {
        return milage;
    }

    public Integer getPower() {
        return power;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public String getDescription() {
        return description;
    }

    public Integer getTestDrive() {
        return testDrive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOcNumber(Integer ocNumber) {
        this.ocNumber = ocNumber;
    }

    public void setRegistrationNumber(Integer registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void setMilage(Long milage) {
        this.milage = milage;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTestDrive(Integer testDrive) {
        this.testDrive = testDrive;
    }
    
    
    
}
