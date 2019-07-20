package com.vastika.training.java.cms;

import com.vastika.training.java.cms.models.Student;
import com.vastika.training.java.cms.repositories.CrudRepository;
import com.vastika.training.java.cms.repositories.impl.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    private CrudRepository<Student> studentRepository;

    public IndexController() {
        this.studentRepository = new StudentRepository();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        List<Student> students = this.studentRepository.findAll();

        model.addAttribute("students", students);
        return "index";
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String getInfo(Model model, @PathVariable("id") int id) {
        Student student = this.studentRepository.findById(id);
        model.addAttribute("student", student);
        return "info";
    }

}
