package com.vastika.training.java.cms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello(Model model, @RequestParam(value = "q", defaultValue = "World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfo(Model model) {
        Student student = new Student(1, "Dheeraj", "Cheetri", 3.0);
        model.addAttribute("student", student);
        return "info";
    }
}
