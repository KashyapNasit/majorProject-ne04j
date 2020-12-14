package com.nasit.majorProject.DataHolder;

public class Data {
    private String  id;
    private String type;
    private String name;
    private String media;

    public String getId() {
        return id;
    }

    public Data setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Data setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public Data setName(String name) {
        this.name = name;
        return this;
    }

    public String getMedia() {
        return media;
    }

    public Data setMedia(String media) {
        this.media = media;
        return this;
    }
}
