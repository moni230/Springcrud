package org.example.springbootcrud.Service;

import org.example.springbootcrud.Entity.Student;
import org.example.springbootcrud.Exception.StudentNotFoundException;
import org.example.springbootcrud.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;


    public List<Student> viewStudents() {

        return repo.findAll();

    }

    public Student addStudents(Student student) {
        System.out.println("Received ID: " + student.getId());
        return repo.save(student);
    }


    public Student updateStudentById( int id, Student student) {

        boolean existsId = repo.existsById(id);

        if(existsId) {

            student.setId(id);
            return repo.save(student);
        }

        else {
            throw new StudentNotFoundException("Student not found with this id: "+id);
        }

    }

    public void deleteStudentById(int delId) {

        boolean exists = repo.existsById(delId);

        if(exists) {
            repo.deleteById(delId);
        }
        else {
            throw new StudentNotFoundException("Student not found with this id "+delId);
        }
    }

    public Optional<Student> viewStudentsById(int id) {

        boolean exists = repo.existsById(id);
        if (exists) {
           return repo.findById(id);
        } else {
            throw new StudentNotFoundException("Student not found with this id: " + id);
        }
    }
}