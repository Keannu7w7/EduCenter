package com.matt.EduCenter.ControlerH;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String face(){
        return "face";
    }
}