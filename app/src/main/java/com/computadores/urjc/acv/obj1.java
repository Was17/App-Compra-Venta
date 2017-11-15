package com.computadores.urjc.acv;

import java.util.ArrayList;

/**
 * Created by was12 on 14/11/2017.
 */

public class obj1 {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private ArrayList<obj2> lista_deseos;
    private ArrayList<obj2> lista_articulos_venta;
    private ArrayList<obj2> lista_vendidos;
    private ArrayList<obj2> lista_compra;

    public obj1(int id, String nombre, String email, String password, ArrayList<obj2> lista_deseos, ArrayList<obj2> lista_articulos_venta, ArrayList<obj2> lista_vendidos, ArrayList<obj2> lista_compra) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.lista_deseos = lista_deseos;
        this.lista_articulos_venta = lista_articulos_venta;
        this.lista_vendidos = lista_vendidos;
        this.lista_compra = lista_compra;
    }

    public obj1() {
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

    public ArrayList<obj2> getLista_deseos() {
        return lista_deseos;
    }

    public void setLista_deseos(ArrayList<obj2> lista_deseos) {
        this.lista_deseos = lista_deseos;
    }

    public ArrayList<obj2> getLista_articulos_venta() {
        return lista_articulos_venta;
    }

    public void setLista_articulos_venta(ArrayList<obj2> lista_articulos_venta) {
        this.lista_articulos_venta = lista_articulos_venta;
    }

    public ArrayList<obj2> getLista_vendidos() {
        return lista_vendidos;
    }

    public void setLista_vendidos(ArrayList<obj2> lista_vendidos) {
        this.lista_vendidos = lista_vendidos;
    }

    public ArrayList<obj2> getLista_compra() {
        return lista_compra;
    }

    public void setLista_compra(ArrayList<obj2> lista_compra) {
        this.lista_compra = lista_compra;
    }
}
