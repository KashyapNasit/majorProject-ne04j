package com.nasit.majorProject.service;

import com.nasit.majorProject.node.Student;
import com.nasit.majorProject.node.Subject;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "subject")
@Tag(name = "subject")
public interface SubjectRepository extends Repository<Subject, String> {
    List<Subject> findAll();

    Optional<Subject> findByCode(String code);

    Optional<Subject> findByName(String name);

    Optional<Subject> findOneByCode(String code);

    Subject findAllByCodeLikeIgnoreCase(String code);

    @RestResource(exported = false)
    List<Subject> findAllByFacultyName(String name);

    @RestResource(exported = false)
    List<Subject> findAllByStudentName(String name);

    @Query("MATCH (n:Student)-[:STUDIES]->(s:Subject) " +
            "WHERE s.code=$code " +
            "RETURN n")
    List<Student> getStudents(String code);

}
