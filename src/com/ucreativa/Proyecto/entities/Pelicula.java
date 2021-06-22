package com.ucreativa.Proyecto.entities;

public class Pelicula extends Proyeccion {

    private String duracion;


    public Pelicula(String nombre, String id, String genero, int periodo, String duracion) {
        super(nombre, id, genero, periodo);
        this.duracion = duracion;
    }

    public String getduracion() {
        return duracion;
    }


    @Override
    public String toString() {
        return this.duracion + " " + super.getNombre();
    }
}
