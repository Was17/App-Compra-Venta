package com.computadores.urjc.acv.Class;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by was12 on 14/11/2017.
 */

public class Articulo implements Serializable {
    private String nombre;
    private String precio;
    private String descripcion;
    private User vendedor;
    private ArrayList<User> usuariosInteresados;
    private Bitmap imagen;
    public Articulo() {
    }

    public Articulo(String nombre, String precio, String descripcion, User vendedor, ArrayList<User> usuariosInteresados) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.vendedor = vendedor;
        this.usuariosInteresados = usuariosInteresados;
    }

    public Articulo(String hola, Bitmap ic_dashboard_black_24dp) {
        this.nombre=hola;
        this.imagen=ic_dashboard_black_24dp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public User getVendedor() {
        return vendedor;
    }

    public void setVendedor(User vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<User> getUsuariosInteresados() {
        return usuariosInteresados;
    }

    public void setUsuariosInteresados(ArrayList<User> usuariosInteresados) {
        this.usuariosInteresados = usuariosInteresados;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }
}
