package com.fwindpeak.bootfirst.entity;

public class Book {
    long id;
    String name;
    String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return "{id:"+id+",name:"+name+",content:"+content+"}";
    }
}
