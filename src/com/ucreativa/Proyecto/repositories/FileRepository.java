package com.ucreativa.Proyecto.repositories;


import com.ucreativa.Proyecto.entities.Pelicula;
import com.ucreativa.Proyecto.entities.Proyeccion;
import com.ucreativa.Proyecto.entities.Serie;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileRepository implements Repository {

    private final String FILE_PATH = "ListaProyecciones.txt";

    @Override
    public void agregarProyeccion(Proyeccion proyeccion, String plataforma) {

        String text;


        if (proyeccion instanceof Pelicula) {
            text = "Nombre de la proyección: " + proyeccion.getNombre()
                    + "  " + "ID: " + proyeccion.getId()
                    + "  " + "Genero: " + proyeccion.getGenero()
                    + "  " + "Año: " + proyeccion.getPeriodo()
                    + "  " + "Plataforma: " + plataforma
                    + "  " + "Duracion: " + ((Pelicula) proyeccion).getduracion()
                    + "\n";
        } else {
            text = "Nombre de la proyección: " + proyeccion.getNombre()
                    + "  " + "ID: " + proyeccion.getId()
                    + "  " + "Genero: " + proyeccion.getGenero()
                    + "  " + "Año: " + proyeccion.getPeriodo()
                    + "  " + "Plataforma: " + plataforma
                    + "  " + "Episodios: " + ((Serie) proyeccion).getNumEpisodios()
                    + "  " + "Temporadas: " + ((Serie) proyeccion).getNumTemporadas()
                    + "\n";
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.append(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            return reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

