/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.idu0020.service;

import ee.idu0020.entity.Shirt;
import java.util.List;

/**
 *
 * @author ilja
 */
public interface ShirtService {

    public List<Shirt> findAll();

    public Shirt findById(int id);

    public void update(Shirt shirt);
    
    public void delete(Shirt shirt);
}
