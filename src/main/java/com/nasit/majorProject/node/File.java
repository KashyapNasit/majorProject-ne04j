package com.nasit.majorProject.node;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class File {

    @Id
    private String id;
    private String type;
    private String name;
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    private List<File> files = new ArrayList<>();

    public List<File> getFiles() {
        return files;
    }

    public File setFiles(List<File> files) {
        this.files = files;
        return this;
    }

    public String getId() {
        return id;
    }

    public File setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public File setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public File setName(String name) {
        this.name = name;
        return this;
    }
}
