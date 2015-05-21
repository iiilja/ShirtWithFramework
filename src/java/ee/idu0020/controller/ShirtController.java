/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.idu0020.controller;

import com.google.gson.Gson;
import ee.idu0020.entity.Shirt;
import ee.idu0020.service.ShirtService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ilja
 */
@Controller
public class ShirtController {

    public ShirtController() {
        System.out.println("\n\nAA\n\n");
    }
    
    
    
    @Autowired(required=true)
    private ShirtService shirtService;
    
    
    @RequestMapping(value = "s", method = RequestMethod.GET)
    public ModelAndView getAllShirts(
            @RequestParam(required = false) Integer id,
            HttpServletRequest request,
            HttpServletResponse response) throws JSONException{
        if (id != null) {
            Map<String, Object> model = new HashMap<>();
            model.put("shirt", shirtService.findById(id));
            return new ModelAndView("shirt", model);//getWithID(id);
        }
        List<Shirt> shirts = shirtService.findAll();
        Map<String, Object> model = new HashMap<>();

        model.put("shirts", shirts);
        return new ModelAndView("shirts", model);
    }
    
    @RequestMapping(value = "s", method = RequestMethod.POST)
    public ModelAndView doSomeAction(
            @RequestParam String action,
            @RequestParam String size,
            @RequestParam String description,
            @RequestParam String cost,
            @RequestParam String id,
            HttpServletRequest request,
            HttpServletResponse response) throws JSONException{
        
        System.out.println("Got id = "+id+" size"+size+" cost"+cost+" desc = "+description);
        if (action != null) {
            switch (action){
                case "save":
                    
                    ShirtError error = ShirtValidation.vld(id, cost, size);
                    Map<String, Object> model = new HashMap<>();
                    Shirt shirt = shirtService.findById(Integer.parseInt(id));
                    if (error == null) {
                        shirt.setSize(size);
                        shirt.setDescription(description);
                        shirt.setCost(Integer.parseInt(cost));
                        shirtService.update(shirt);
                        
                    } else {
                        model.put("formError", error);
                    }
                    model.put("shirt", shirt);
                    return new ModelAndView("shirt",model);
                case "create":
                    
                    break;
            }
            return null;
        }
        return null;
    }

    
    @ExceptionHandler(Exception.class)
    public void handleAllException(Exception ex) {
        System.err.println(ex.getMessage());
        ex.printStackTrace();
    }
}
