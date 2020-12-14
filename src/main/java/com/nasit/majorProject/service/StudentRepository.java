package com.nasit.majorProject.service;

import com.nasit.majorProject.node.Student;
import com.nasit.majorProject.node.Subject;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface StudentRepository extends Repository<Student, String> {
    Optional<Student> findByRegno(String code);
    Optional<Student> findByName(String name);
}
