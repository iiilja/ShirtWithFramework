/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.idu0020.controller;

import ee.idu0020.entity.Shirt;
import javax.persistence.Column;

/**
 *
 * @author iiilja
 */
public class ShirtError {
    private String size;
    private String cost;
    private String description;

    public ShirtError() {
    }
    
    

    public ShirtError(String size, String cost, String description) {
        this.size = size;
        this.cost = cost;
        this.description = description;
    }

    


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
