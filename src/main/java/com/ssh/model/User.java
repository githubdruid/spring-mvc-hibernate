package com.ssh.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "USER_TBL")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "UID")
    private Long id;

    @Column(name = "NAME")
    @Size(max = 20, min = 3, message = "{user.name.invalid}")
    private String name;

    @Column(name = "EMAIL", unique = true)
    @Email(message = "{user.email.invalid}")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
