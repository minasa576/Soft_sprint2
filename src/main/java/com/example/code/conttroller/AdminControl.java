package com.example.code.conttroller;


import com.example.code.Codes.ActorSubSystem.Admin;
import com.example.code.Codes.DriverproperiesSubSystem.RegistrationDriver;
import com.example.code.Codes.DataBaseSubSystem.Database;
import com.example.code.Codes.DataBaseSubSystem.GeneralDatabase;
import com.example.code.Codes.RequestTripmangerSubSystem.Area;
import com.example.code.Codes.TripEvent.TripEvent;
import org.springframework.web.bind.annotation.*;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

import java.util.ArrayList;

@RestController
public class AdminControl {
    GeneralDatabase Ad= Database.getInstance();
    Admin bob = new Admin("bob","bob123");
    boolean check=false;

    @PostMapping("/Admin/login/{email}/{pass}/")
    public String login(@PathVariable String email, @PathVariable String pass) {
        if(bob.logIn().equalsIgnoreCase("LogIn Successful")){
            check=true;
            return bob.logIn();
        }
        else
        {
            return bob.logIn();
        }
    }

    @PostMapping("/Admin/adddisArea/")
    public String addDisArea(@RequestBody Area area) {
        if(check){
            return bob.addDisArea(area);
        }
        else{
            return "You are not Login";
        }
    }

    @PostMapping("/Admin/verification/{id}")
    public String verifyDriver(@PathVariable int id) {
        if(check){
            return bob.verify(id);
        }
        else{
            return "You are not Login";
        }
    }

    @GetMapping("/Admin/viweListRegDriver/")
    public ArrayList<RegistrationDriver> viweListRegDriver() {
        if(check){
            return bob.viweListRegDriver();
        }
        else{
            return null;
        }
    }

    @PostMapping("/Admin/Susbend/{id}")
    public String SusbendUser(@PathVariable int id) {
        if(check){
            return bob.suspend(id);
        }
        else{
            return "You are Not logIn";
        }
    }
    @GetMapping("/Admin/viewtrip/{id}")
    public TripEvent viewTrip(@PathVariable int id)
    {return  bob.viewEvent(id);}
}
