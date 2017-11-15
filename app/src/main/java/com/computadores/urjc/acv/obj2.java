package com.computadores.urjc.acv;

import java.util.ArrayList;

/**
 * Created by was12 on 14/11/2017.
 */

public class obj2 {
    private String nombre;
    private long precio;
    private String descripcion;
    private obj1 vendedor;
    private ArrayList<obj1> usuariosInteresados;
    private int imagen;
    public obj2() {
    }

    public obj2(String nombre, long precio, String descripcion, obj1 vendedor, ArrayList<obj1> usuariosInteresados, int imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.vendedor = vendedor;
        this.usuariosInteresados = usuariosInteresados;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public obj1 getVendedor() {
        return vendedor;
    }

    public void setVendedor(obj1 vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<obj1> getUsuariosInteresados() {
        return usuariosInteresados;
    }

    public void setUsuariosInteresados(ArrayList<obj1> usuariosInteresados) {
        this.usuariosInteresados = usuariosInteresados;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
