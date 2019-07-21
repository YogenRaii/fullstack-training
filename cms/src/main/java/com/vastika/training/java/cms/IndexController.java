package com.vastika.training.java.cms;

import com.vastika.training.java.cms.models.Student;
import com.vastika.training.java.cms.repositories.CrudRepository;
import com.vastika.training.java.cms.repositories.impl.StudentRepository;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfo(Model model, @RequestParam("studentId") int id) {
        Student student = this.studentRepository.findById(id);
        model.addAttribute("student", student);
        return "info";
    }

    @RequestMapping(value = "/students/{id}/edit", method = RequestMethod.GET)
    public String getUpdateForm(Model model, @PathVariable("id") int id) {
        Student student = this.studentRepository.findById(id);
        model.addAttribute("student", student);
        return "studentForm";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String upsertStudent(@ModelAttribute("student") Student student) {
        this.studentRepository.update(student);
        return "redirect:/";
    }
}
