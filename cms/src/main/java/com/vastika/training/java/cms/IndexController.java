package com.vastika.training.java.cms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Dheeraj", "Cheetri", 4.0));
        students.add(new Student(2, "Roshan", "Shrestha", 4.0));
        students.add(new Student(3, "Saurav", "Shrestha", 3.8));
        students.add(new Student(4, "Nabin", "Thapa", 4.0));

        model.addAttribute("students", students);
        return "index";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfo(Model model) {
        Student student = new Student(1, "Dheeraj", "Cheetri", 3.0);
        model.addAttribute("student", student);
        return "info";
    }

}
