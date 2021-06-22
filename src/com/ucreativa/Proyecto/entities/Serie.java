package com.ucreativa.Proyecto.entities;

public class Serie extends Proyeccion {

    private String numTemporadas;
    private String numEpisodios;

    public Serie(String nombre, String id, String genero, int periodo, String numTemporadas, String numEpisodios) {
        super(nombre, id, genero, periodo);
        this.numTemporadas = numTemporadas;
        this.numEpisodios = numEpisodios;
    }

    public String getNumTemporadas() {
        return numTemporadas;
    }

    public String getNumEpisodios() {
        return numEpisodios;
    }


    @Override
    public String toString() {
        return this.numTemporadas + " " + this.numEpisodios + " " + super.getNombre();
    }
}
