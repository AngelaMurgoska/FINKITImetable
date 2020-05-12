package com.example.demo.models;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name="professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    @Column(columnDefinition = "NVARCHAR(255)")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
