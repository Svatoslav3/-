package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
public class Models {


    @Entity
    @Data
    @Table(name = "Users")
    public class User {
        @Id
        private String userId;
        private String password;

        @ManyToOne
        @JoinColumn(name = "role_ID")
        private Role role;

        private String name;
    }

    @Entity
    @Data
    @Table(name = "Role")
    public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long roleId;

        @Column(unique = true)
        private String name;

        @OneToMany(mappedBy = "role")
        private List<User> users;
    }

    @Entity
    @Data
    @Table(name = "Tasks")
    public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long taskId;

        @ManyToOne
        @JoinColumn(name = "user_ID")
        private User user;

        @ManyToOne
        @JoinColumn(name = "status_ID")
        private Status status;

        private String name;
        private String shortDescription;
        private String description;
        private String serviceLink;
        private String contacts;
        private String date;
    }

    @Entity
    @Data
    @Table(name = "Organizations")
    public class Organization {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long organizationId;

        @Column(unique = true)
        private String name;

        private String description;
        private String contacts;

        @OneToMany(mappedBy = "organization")
        private List<Favorite> favorites;
    }

    @Entity
    @Data
    @Table(name = "Favorites")
    public class Favorite {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long favId;

        @ManyToOne
        @JoinColumn(name = "user_ID")
        private User user;

        @ManyToOne
        @JoinColumn(name = "task_ID")
        private Task task;

        @ManyToOne
        @JoinColumn(name = "organization_ID")
        private Organization organization;

        private String surname;
    }
}
