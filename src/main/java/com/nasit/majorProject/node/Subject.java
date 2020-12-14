package com.nasit.majorProject.node;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Subject {

    @Id
    @Property("code")
    private String code;

    @Property("name")
    private String name;

    @Property("credit")
    private Integer credit;

    @Relationship(type = "TEACHES", direction = Relationship.Direction.INCOMING)
    private List<Faculty> faculty = new ArrayList<>();

    @Relationship(type = "STUDIES", direction = Relationship.Direction.INCOMING)
    private List<Student> student = new ArrayList<>();

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<File> files = new ArrayList<>();


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFaculty() {
        return faculty;
    }

    public Subject setFaculty(List<Faculty> faculty) {
        this.faculty = faculty;
        return this;
    }

    public List<Student> getStudents() {
        return student;
    }

    public Subject setStudent(List<Student> students) {
        this.student = students;
        return this;
    }

    public Subject setCode(String code) {
        this.code = code;
        return this;
    }

    public Subject setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCredit() {
        return credit;
    }

    public Subject setCredit(Integer credit) {
        this.credit = credit;
        return this;
    }

    public List<File> getFiles() {
        return files;
    }

    public Subject setFiles(List<File> files) {
        this.files = files;
        return this;
    }

    public List<Student> getStudent() {
        return student;
    }

}
