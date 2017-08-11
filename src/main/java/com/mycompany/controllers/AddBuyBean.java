/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;


import com.mycompany.komissamochodowy.model.Car;
import com.mycompany.komissamochodowy.model.Client;
import java.math.BigDecimal;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author RENT
 */
@ManagedBean(name = "addBuyBean")
@RequestScoped
public class AddBuyBean {
    
    
    private Client client;
    private Car car;
    private String text;
    private Date date;
    private BigDecimal amount;
    
    
    
}
