package com.nasit.majorProject.service;

import com.nasit.majorProject.node.Student;
import com.nasit.majorProject.node.Subject;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.slf4j.Logger;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.sound.midi.Receiver;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    private final Driver driver;

    private final Logger logger;

    public SubjectService(SubjectRepository subjectRepository, Driver driver) {
        this.subjectRepository = subjectRepository;
        this.driver = driver;
        this.logger = LoggerFactory.getLogger(SubjectService.class);
    }

    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    public Subject getSubjectByName(String name){
        Optional<Subject> subject = subjectRepository.findByName(name);
        if(subject.isPresent()){
            return subject.get();
        }
        return null;
    }

    public Subject getSubjectByCode(String code){
        return subjectRepository.findAllByCodeLikeIgnoreCase(code);
    }

    public List<Student> getStudents(String code){
        var query = "MATCH (n:Student)-[:STUDIES]->(s:Subject) " +
                "WHERE s.code=\"" +code+"\" "+
                "RETURN n";
        logger.info(query);
        try (Session session = driver.session()) {
            List<Student> students = session.readTransaction(t -> {
                Result result = t.run(query);
                List<Student> s = new ArrayList<>();
                while(result.hasNext()){
                    Record next = result.next();
                    s.add(new Student().setName(next.values().get(0).get("name").toString().replace("\"","")).setRegno(next.values().get(0).get("regno").toString().replace("\"","")));
                }
                return s;
            });
            return students;
        }
    }
}

