/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.idu0020.service;

import ee.idu0020.entity.Shirt;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ilja
 */
@Transactional
@Service
public class ShirtServiceImpl implements ShirtService{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public List<Shirt> findAll(){
        Session session = sessionFactory.getCurrentSession();
        return session.getNamedQuery("Shirt.findAll").list();
    }
    
    @Override
    public Shirt findById(int id){
        Session session = sessionFactory.getCurrentSession();
        return (Shirt) session.getNamedQuery("Shirt.findById").setParameter("id", id).uniqueResult();
    }
    
    @Override
    public void update(Shirt shirt){
        Session session = sessionFactory.getCurrentSession();
        session.update(shirt);
        session.flush();
    }
    
    @Override
    public void delete(Shirt shirt){
        Session session = sessionFactory.getCurrentSession();
        session.delete(shirt);
        session.flush();
    }
}
