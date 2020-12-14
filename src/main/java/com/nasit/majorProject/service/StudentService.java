package com.nasit.majorProject.service;

import com.nasit.majorProject.node.Student;
import org.springframework.stereotype.Service;
import org.neo4j.driver.Driver;

import java.util.Optional;

@Service
public class StudentService {
    private final Driver driver;
    private final StudentRepository studentRepository;

    public StudentService(Driver driver, StudentRepository studentRepository) {
        this.driver = driver;
        this.studentRepository = studentRepository;
    }

    public Student getByName(String name){
        Optional<Student> s = studentRepository.findByName(name);
        if(s.isPresent()){
            return s.get();
        }
        return null;
    }

    public Student getByRegno(String regno){
        Optional<Student> s = studentRepository.findByRegno(regno);
        if(s.isPresent()){
            return s.get();
        }
        return null;
    }
}
