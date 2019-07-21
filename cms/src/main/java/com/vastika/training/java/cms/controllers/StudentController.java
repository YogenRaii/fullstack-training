package com.vastika.training.java.cms.controllers;

import com.vastika.training.java.cms.models.Student;
import com.vastika.training.java.cms.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String index(Model model) {
        List<Student> students = this.studentRepository.findAll();

        model.addAttribute("students", students);
        return "students";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfo(Model model, @RequestParam("studentId") int id) {
        Student student = this.studentRepository.getOne(id);
        model.addAttribute("student", student);
        return "studentInfo";
    }

    @RequestMapping(value = "/students/{id}/edit", method = RequestMethod.GET)
    public String getUpdateForm(Model model, @PathVariable("id") int id) {
        Student student = this.studentRepository.getOne(id);
        model.addAttribute("formType", "Update");
        model.addAttribute("student", student);
        return "studentForm";
    }

    @RequestMapping(value = "/students/add", method = RequestMethod.GET)
    public String getAddForm(Model model) {
        Student student = new Student();
        model.addAttribute("formType", "Add");
        model.addAttribute("student", student);
        return "studentForm";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String upsertStudent(@ModelAttribute("student") Student student) {
        this.studentRepository.save(student);

        return "redirect:/students";
    }

    @RequestMapping(value = "/students/{id}/delete", method = RequestMethod.GET)
    public String deleteStudentRecord(@PathVariable int id) {
        this.studentRepository.deleteById(id);
        return "redirect:/students";
    }
}
