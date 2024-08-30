package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Data
@Table(name = "Status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "status")
    private List<Models.Task> tasks;

    public Status(Long statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    public Status() {}
}