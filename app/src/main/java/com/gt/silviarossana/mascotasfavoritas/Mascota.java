package com.gt.silviarossana.mascotasfavoritas;

import java.io.Serializable;

/**
 * Created by Silvia Rossana on 22/01/2017.
 */

public class Mascota implements Serializable {

    private String nombre;
    private int foto;
    private String numLike;

    public Mascota(String nombre, int foto, String numLike) {
        this.nombre = nombre;
        this.foto = foto;
        this.numLike = numLike;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNumLike() {
        return numLike;
    }

    public void setNumLike(String numLike) {
        this.numLike = numLike;
    }
}
