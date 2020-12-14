package com.nasit.majorProject.node;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
//import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.ArrayList;
import java.util.List;

@Node
public class Student {

    @Id
    private String regno;

    private String name;

    @Relationship(type = "STUDIES", direction = Relationship.Direction.OUTGOING)
    private List<Student> subject = new ArrayList<>();

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<File> files = new ArrayList<>();

    public String getRegno() {
        return regno;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Student setRegno(String regno) {
        this.regno = regno;
        return this;
    }

    public List<Student> getSubject() {
        return subject;
    }

    public Student setSubject(List<Student> subject) {
        this.subject = subject;
        return this;
    }

    public List<File> getFiles() {
        return files;
    }

    public Student setFiles(List<File> files) {
        this.files = files;
        return this;
    }
}
