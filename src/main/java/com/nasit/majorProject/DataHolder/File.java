package com.nasit.majorProject.DataHolder;

public class File {
    private Integer status;
    private Data data;

    public Integer getStatus() {
        return status;
    }

    public File setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Data getData() {
        return data;
    }

    public File setData(Data data) {
        this.data = data;
        return this;
    }
}
