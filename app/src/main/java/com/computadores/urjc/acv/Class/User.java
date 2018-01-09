package com.computadores.urjc.acv.Class;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by was12 on 14/11/2017.
 */

public class User implements Serializable{
    private int id;
    private String nombre;
    private String email;
    private String password;
    private int Foto;
    private ArrayList<Articulo> lista_deseos;
    private ArrayList<Articulo> lista_articulos_venta;
    private ArrayList<Articulo> lista_vendidos;
    private ArrayList<Articulo> lista_compra;
    private ArrayList<Chat> chats;

    public User(int id, String nombre, String email, String password, ArrayList<Articulo> lista_deseos, ArrayList<Articulo> lista_articulos_venta, ArrayList<Articulo> lista_vendidos, ArrayList<Articulo> lista_compra) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.lista_deseos = lista_deseos;
        this.lista_articulos_venta = lista_articulos_venta;
        this.lista_vendidos = lista_vendidos;
        this.lista_compra = lista_compra;
    }

    public User() {
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

    public ArrayList<Articulo> getLista_deseos() {
        return lista_deseos;
    }

    public void setLista_deseos(ArrayList<Articulo> lista_deseos) {
        this.lista_deseos = lista_deseos;
    }

    public ArrayList<Articulo> getLista_articulos_venta() {
        return lista_articulos_venta;
    }

    public void setLista_articulos_venta(ArrayList<Articulo> lista_articulos_venta) {
        this.lista_articulos_venta = lista_articulos_venta;
    }

    public ArrayList<Articulo> getLista_vendidos() {
        return lista_vendidos;
    }

    public void setLista_vendidos(ArrayList<Articulo> lista_vendidos) {
        this.lista_vendidos = lista_vendidos;
    }

    public ArrayList<Articulo> getLista_compra() {
        return lista_compra;
    }

    public void setLista_compra(ArrayList<Articulo> lista_compra) {
        this.lista_compra = lista_compra;
    }
}
