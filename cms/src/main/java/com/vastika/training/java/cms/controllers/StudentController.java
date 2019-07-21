package com.vastika.training.java.cms.controllers;

import com.vastika.training.java.cms.models.Student;
import com.vastika.training.java.cms.repositories.CrudRepository;
import com.vastika.training.java.cms.repositories.impl.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    private CrudRepository<Student> studentRepository;

    public StudentController() {
        this.studentRepository = new StudentRepository();
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String allStudents(Model model) {
        List<Student> students = this.studentRepository.findAll();

        model.addAttribute("students", students);
        return "students";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfo(Model model, @RequestParam("studentId") int id) {
        Student student = this.studentRepository.findById(id);
        model.addAttribute("student", student);
        return "studentInfo";
    }

    @RequestMapping(value = "/students/{id}/edit", method = RequestMethod.GET)
    public String getUpdateForm(Model model, @PathVariable("id") int id) {
        Student student = this.studentRepository.findById(id);
        model.addAttribute("student", student);
        return "studentForm";
    }

    @RequestMapping(value = "/students/{id}/delete", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") int id, Model model) {
        boolean deleted = this.studentRepository.deleteById(id);
        if (deleted) {
            return "redirect:/";
        }
        model.addAttribute("errorMsg", "Error while deleting record with id " + id);
        return "error";
    }

    @RequestMapping(value = "/students/add", method = RequestMethod.GET)
    public String getAddForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "studentForm";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String upsertStudent(@ModelAttribute("student") Student student, Model model) {
        if (student.getId() <= 0) {
            studentRepository.insert(student);
        } else {
            studentRepository.update(student);
        }
        return "redirect:/";
    }

}
