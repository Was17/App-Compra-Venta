package com.computadores.urjc.acv.Class;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by was12 on 14/11/2017.
 */

public class Chat implements Serializable{
    private int id;
    private User comprador;
    private User vendedor;
    private ArrayList<Mensaje> mensajes;
    private void Chat(){

    }

    public Chat(User comprador, User vendedor) {
        this.comprador = comprador;
        this.vendedor = vendedor;
    }

    public Chat(int id,User comprador, User vendedor, ArrayList<Mensaje> mensajes) {
        this.id=id;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.mensajes = mensajes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getComprador() {
        return comprador;
    }

    public void setComprador(User comprador) {
        this.comprador = comprador;
    }

    public User getVendedor() {
        return vendedor;
    }

    public void setVendedor(User vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}
