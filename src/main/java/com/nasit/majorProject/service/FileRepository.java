package com.nasit.majorProject.service;

import com.nasit.majorProject.node.File;
import com.nasit.majorProject.node.Student;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface FileRepository extends Repository<File, String> {
    Optional<File> findByName(String name);
    Optional<File> findById(String id);
    Optional<File> findByType(String type);

}
