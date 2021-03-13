package com.rasool.test.controller;

import com.rasool.test.dto.LoginResponse;
import com.rasool.test.model.Student;
import com.rasool.test.model.User;
import com.rasool.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins="*")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public String create(ServletRequest request, @RequestBody Student student){
        Student s = new Student() ;
        s.setName("Razool");
        s.setAge(23);
        studentRepository.save(s);
        return "Success";
    }

    @GetMapping
    public List<Student> getStudent(ServletRequest request){
//        LoginResponse lr = new LoginResponse();
//        try{
//            List<Student> loginResponses = studentRepository.findAll();
//            lr.setCode(200);
//            lr.setResponseData(loginResponses);
//        }catch(Exception ex){
//        }

        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(ServletRequest request, @PathVariable Long id){
        return studentRepository.findById(id);
    }

    @PutMapping("/{id}")
    public String update(ServletRequest request, @PathVariable Long id, @RequestBody Student student){
        Student student1 = new Student();
        student1.setName("######");
        return "";
    }
}
