package org.example.springbootcrud.Controller;

import jakarta.validation.Valid;
import org.example.springbootcrud.Entity.Student;
import org.example.springbootcrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired

    StudentService service;

    @GetMapping("/viewstudents")
    public List<Student> viewStudent() {
        return service.viewStudents();

    }

    @PostMapping("/addstudents")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(service.addStudents(student));

    }

    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        return ResponseEntity.ok(service.updateStudentById(id, student));

    }

    @DeleteMapping("/deletestudent/{delId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int delId) {
        service.deleteStudentById(delId);
        return ResponseEntity.ok("Student details deleted");

    }

    @GetMapping("/viewstudents/{id}")
        public ResponseEntity<Optional<Student>> viewStudentById (@PathVariable int id){

            Optional<Student> studata = service.viewStudentsById(id);
            return ResponseEntity.ok(studata);

        }
    }