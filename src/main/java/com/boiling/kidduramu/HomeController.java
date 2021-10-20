package com.boiling.kidduramu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", ""})
    public String index(){

        return "index";
    }

    @GetMapping(value = {"/contentUs"})
    public String contectUs(){
        return "contectUs";
    }

}
