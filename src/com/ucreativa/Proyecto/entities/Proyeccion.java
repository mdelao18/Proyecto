package com.ucreativa.Proyecto.entities;

public abstract class Proyeccion {

    private String nombre;
    private String id;
    private String genero;
    private int periodo;

    public Proyeccion(String nombre, String id, String genero, int periodo) {
        this.nombre = nombre;
        this.id = id;
        this.genero = genero;
        this.periodo = periodo;
    }

    public abstract String toString();

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getGenero() {
        return genero;
    }

    public int getPeriodo() {
        return periodo;
    }

}
