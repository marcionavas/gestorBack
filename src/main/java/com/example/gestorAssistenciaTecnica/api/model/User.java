package com.example.gestorAssistenciaTecnica.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jefferson
 */
@Entity
@Table(name = "user", schema = "public")
public class User {

    private Long id;
    private String username;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    
    @Column(name = "username",unique=true)
    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassworld() {
        return password;
    }

    public void setPassworld(String passworld) {
        this.password = passworld;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

}
