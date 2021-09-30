package co.com.sofka.personalizedtraining.domain.entrenador;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;

public class Funcion extends Entity<FuncionId> {
    private final Nombre nombre;
    private final Capacidad capacidad;
    private final Experiencia experiencia;
    private final Descripcion descripcion;

    public Funcion(FuncionId entityId, Nombre nombre, Capacidad capacidad, Experiencia experiencia, Descripcion descripcion) {
        super(entityId);
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.experiencia = experiencia;
        this.descripcion = descripcion;
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
