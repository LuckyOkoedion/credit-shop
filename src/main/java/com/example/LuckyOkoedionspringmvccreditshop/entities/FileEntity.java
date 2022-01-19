package com.example.LuckyOkoedionspringmvccreditshop.entities;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class FileEntity {

    @Id
    @GeneratedValue()
    private Long id;
    @Column
    private String name;
    @Column
    private String contentType;
    @Column
    private Long size;

    @Lob
    @Column
    private byte[] data;


    public FileEntity() {

    }

    public FileEntity(String name, String contentType, Long size, byte[] data) {

        super();

        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.data = data;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
