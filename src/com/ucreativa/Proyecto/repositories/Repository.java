package com.ucreativa.Proyecto.repositories;

import com.ucreativa.Proyecto.entities.Proyeccion;

import java.util.List;

public interface Repository {

    void agregarProyeccion(Proyeccion proyeccion, String plataforma);

    List<String> get();
}
