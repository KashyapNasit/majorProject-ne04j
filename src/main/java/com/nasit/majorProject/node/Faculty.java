package com.nasit.majorProject.node;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Faculty {

    private String name;

    @Id
    private String eid;

    @Relationship(type = "TEACHES", direction = Relationship.Direction.OUTGOING)
    private List<Faculty> subjects = new ArrayList<>();

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<File> files = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Faculty setName(String name) {
        this.name = name;
        return this;
    }

    public String getEid() {
        return eid;
    }

    public Faculty setEid(String eid) {
        this.eid = eid;
        return this;
    }

    public List<Faculty> getSubjects() {
        return subjects;
    }

    public Faculty setSubjects(List<Faculty> subjects) {
        this.subjects = subjects;
        return this;
    }

    public List<File> getFiles() {
        return files;
    }

    public Faculty setFiles(List<File> files) {
        this.files = files;
        return this;
    }
}
