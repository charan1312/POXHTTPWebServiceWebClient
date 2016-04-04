package asu.edu.pox.http.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.jersey.api.client.ClientResponse;

import asu.edu.pox.http.services.*;

@Controller
public class HomeController {
    @Autowired
    ClientService cs;// = new ClientService();
    
    @RequestMapping(value="/fooditem")
    //@ResponseBody
    public ModelAndView processreq(@RequestParam("textb") String input) {
        
        //ClientService cs = new ClientService();
        ClientResponse outputResponseObject =  cs.postFoodItemRequest(input);

        StringBuffer message= new StringBuffer().append(outputResponseObject.getStatus());
        message.append("\n\n");
        message.append(outputResponseObject.getEntity(String.class));
        System.out.println(message);
        cs.close();
        return new ModelAndView("out","message",message.toString()); 
    }
}
