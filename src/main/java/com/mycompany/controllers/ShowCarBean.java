/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.Dtos.CarDto;
import com.mycompany.komissamochodowy.database.ConfigHibernate;
import com.mycompany.komissamochodowy.model.Car;
import java.util.ArrayList;
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
@ManagedBean(name = "showCarBean")
@RequestScoped
public class ShowCarBean {

    private String filterType;
    private String filterValue;
    
    private CarDto carDto = new CarDto();    
    private CarDto filter = new CarDto();
    
    private List<CarDto> carsDto = new ArrayList<>();

    public List<CarDto> getCarsDto() {
        
        return getList();
    }

    public void setCarsDto(List<CarDto> carsDto) {
        this.carsDto = carsDto;
    }

    
    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }    
    
    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    
    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }    

    public CarDto getFilter() {
        return filter;
    }

    public void setFilter(CarDto filter) {
        this.filter = filter;
    }   
    
    
    
    public List<CarDto> getList(){
        SessionFactory instance = ConfigHibernate.getInstance();
        Session session = instance.openSession();
       
        Query query;
        if(filterType == null || filterValue == null)
        {              
            query = session.createQuery("FROM Car");
        }
        else
        {                        
            if(filterType.equals("brak"))
            {   
                query = session.createQuery("FROM Car");                
            }
            else
            {                            
                query = session.createQuery("FROM Car as c where c."+ filterType + " like ?")
                        .setString(0, "%"+filterValue+"%");           
            }
        }
        
        List <Car> cars = query.list();
        
        List<CarDto> carsDto = new ArrayList<>();
        
        for(Car c : cars)
        {
            CarDto newCarDto = new CarDto();
            newCarDto = carToCarDto(c);
            carsDto.add(newCarDto);        
        }
        
        return carsDto;
    }
    
    public void filteredTable()
    {    
//        if(filterType.equals("brak"))
//        {                    
//            getList(null);
//        }
//        else
//        {
//            getList("FROM Car c where c."+ filterType +" like " + filterValue);        
//        }
        
        System.out.println("");
    }
    
    
   
    public CarDto carToCarDto(Car car)
    {
        CarDto newCarDto = new CarDto();
        
        newCarDto.setBrand(car.getBrand());
        newCarDto.setDescription(car.getDescription());
        newCarDto.setFuelType(car.getFuelType());
        newCarDto.setId(car.getId());
        newCarDto.setMilage(car.getMilage());
        newCarDto.setModel(car.getModel());
        newCarDto.setOcNumber(car.getOcNumber());
        newCarDto.setPower(car.getPower());
        newCarDto.setProductionYear(car.getProductionYear());
        newCarDto.setRegistrationNumber(car.getRegistrationNumber());       
        newCarDto.setTestDrive(car.getTestDrive());       
        newCarDto.setTransmission(car.getTransmission());       
        newCarDto.setVin(car.getVin());       
        
        return newCarDto;
    
    }
}
