/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.idu0020.controller;

import com.google.gson.Gson;
import ee.idu0020.entity.Shirt;
import ee.idu0020.service.ShirtService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ilja
 */
@Controller
public class SecondServletController {

    public SecondServletController() {
        System.out.println("\n\nBBB\n\n");
    }
    
    
    
    @Autowired(required=true)
    private ShirtService shirtService;
    

    
    @RequestMapping(value = "shirtService")
    public @ResponseBody String getShirt(
            @RequestParam (required = true ) int id,
            HttpServletRequest request,
            HttpServletResponse response) throws JSONException{
        return getWithID(id);
    }

    private String getWithID(Integer id) {
        Shirt shirt = shirtService.findById(id);
        Gson gson = new Gson();
        return gson.toJson(shirt);
    }
    
    @ExceptionHandler(Exception.class)
    public void handleAllException(Exception ex) {
        System.err.println(ex.getMessage());
        ex.printStackTrace();
    }
}

