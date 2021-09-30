package co.com.sofka.personalizedtraining.domain.entrenador;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;

import java.util.Objects;

public class Funcion extends Entity<FuncionId> {
    private Nombre nombre;
    private Capacidad capacidad;
    private Experiencia experiencia;
    private Descripcion descripcion;

    public Funcion(FuncionId entityId, Nombre nombre, Capacidad capacidad, Experiencia experiencia, Descripcion descripcion) {
        super(entityId);
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.experiencia = experiencia;
        this.descripcion = descripcion;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarCapacidad(Capacidad capacidad){
        this.capacidad = Objects.requireNonNull(capacidad);
    }

    public void actualizarExperiencia(Experiencia experiencia){
        this.experiencia = Objects.requireNonNull(experiencia);
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Nombre nombre() {
        return nombre;
    }

    public Capacidad capacidad() {
        return capacidad;
    }

    public Experiencia experiencia() {
        return experiencia;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
