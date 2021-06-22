package com.ucreativa.Proyecto.services;

import com.ucreativa.Proyecto.entities.Pelicula;
import com.ucreativa.Proyecto.entities.Proyeccion;
import com.ucreativa.Proyecto.entities.Serie;
import com.ucreativa.Proyecto.repositories.Repository;
import com.ucreativa.Proyecto.ui.ErroresNumericosException;

import java.util.List;

public class PlataformaServices {

    private Repository repository;


    public PlataformaServices(Repository repository) {
        this.repository = repository;
    }

    public void agregarProyeccion(String nombre, String id, String genero, String txtPeriodo, boolean isPelicula,
                                  String numEpisodios, String numTemporadas, String duracion, String plataforma) throws ErroresNumericosException {

        int periodo;
        //Profe deje solo el periodo (Año) para el exception, intente con numEpisodios,temporadas y duracion, pero no funciono, entonces le deje solo periodo para que funcionara.
        try {
            periodo = Integer.parseInt(txtPeriodo);
        } catch (NumberFormatException x) {
            throw new ErroresNumericosException(txtPeriodo);
        }
        Proyeccion proyeccion;

        if (isPelicula) {
            proyeccion = new Pelicula(nombre, id, genero, periodo, duracion);
        } else {
            proyeccion = new Serie(nombre, id, genero, periodo, numEpisodios, numTemporadas);
        }
        this.repository.agregarProyeccion(proyeccion, plataforma);
    }

    public List<String> get() {
        return this.repository.get();
    }
}
