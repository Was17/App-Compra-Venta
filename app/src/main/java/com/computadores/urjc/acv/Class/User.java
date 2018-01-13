package com.computadores.urjc.acv.Class;

import java.io.Serializable;

/**
 * Created by was12 on 14/11/2017.
 */

public class User implements Serializable{
    private int id;
    private String nombre;
    private String email;
    private String password;


    public User() {
    }

    public User(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public User(String name) {
        this.nombre=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
