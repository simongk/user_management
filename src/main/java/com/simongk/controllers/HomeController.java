package com.simongk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Szymon on 2017-02-13.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping()
    public String home(){
        return "index";
    }
}
