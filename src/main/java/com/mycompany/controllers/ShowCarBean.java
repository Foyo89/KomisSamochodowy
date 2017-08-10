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
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author RENT
 */
@ManagedBean(name = "showCarBean")
@SessionScoped
public class ShowCarBean {

    private String filterType;
    private String filterValue;
    
    private int pageSize = 5;
    private int page = 0;
    
    private int counter;
    
    private boolean pagination = false;
    private boolean previousPageControl;
    private boolean nextPageControl;
    
    private List<Car> cars;
    
    private CarDto carDto = new CarDto();        
    private List<CarDto> carsDto = new ArrayList<>();
    
    
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
        if (pagination && page+page<counter)
            nextPageControl = true;
        else nextPageControl = false;
        return nextPageControl;
    }
    
    private void setCars(){
           

            cars = session.createQuery("FROM Car")
            .list();
            if (cars.size() > pageSize) pagination = true;
            
            
    }
    
    
    public void nextPage(){
        page = page+pageSize;
    }
    
    public void previousPage(){
        page = page-pageSize;
    }
    
////////////////////////////////////////////////
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

    public List<CarDto> getList(){
        //this.setCars();
        
        
        
        //session = instance.openSession();
       
        Query query;
        if(filterType == null || filterValue == null)
        {              
            query = session.createQuery("FROM Car");        
                    counter = query.list().size();
        }
        else
        {                        
            if(filterType.equals("brak"))
            {   
                query = session.createQuery("FROM Car");
                        counter = query.list().size();
                
            }
            else
            {                            
                query = session.createQuery("FROM Car as c where c."+ filterType + " like ?")
                        .setString(0, "%"+filterValue+"%");
                        counter = query.list().size();
               // List <Car> temp = query.list();
                //temp.size();
//                if (temp.size() < pageSize) pagination =false;
//                else pagination = true;
            }
        }
        
        
       if (counter>pageSize) pagination = true;
       else pagination=false;
        
        query = query.setMaxResults(pageSize)
                .setFirstResult(page);
                
        List <Car> cars = query.list();
        //if (cars.size() > pageSize) pagination=true;
        List<CarDto> carsDto = new ArrayList<>();
        
        
        for(Car c : cars)
        {
            CarDto newCarDto = new CarDto();
            newCarDto = carToCarDto(c);
            carsDto.add(newCarDto);        
        }
        
        return carsDto;
    }
    
    public String filteredTable()
    {    
        page = 0;
        return "showscars.xhtml";
    }
    
     public String viewCar(CarDto carDto) {   
        this.carDto = carDto;
        return "cardetails.xhtml";
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
