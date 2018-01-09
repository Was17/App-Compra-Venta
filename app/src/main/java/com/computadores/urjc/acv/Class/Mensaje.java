package com.computadores.urjc.acv.Class;

import java.io.Serializable;

/**
 * Created by was12 on 04/01/2018.
 */

public class Mensaje implements Serializable{
    private int id;
    private String mensaje;
    private long time;
    public void Mensaje(){

    }

    public Mensaje(String mensaje, long time) {
        this.mensaje = mensaje;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
