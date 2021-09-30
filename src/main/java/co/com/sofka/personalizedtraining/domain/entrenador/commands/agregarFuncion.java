package co.com.sofka.personalizedtraining.domain.entrenador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;

public class agregarFuncion extends Command {
    private final EntrenadorId entrenadorId;
    private final FuncionId entityId;
    private final Nombre nombre;
    private final Capacidad capacidad;
    private final Experiencia experiencia;
    private final Descripcion descripcion;

    public agregarFuncion(EntrenadorId entrenadorId, FuncionId entityId, Nombre nombre, Capacidad capacidad, Experiencia experiencia, Descripcion descripcion) {
        this.entrenadorId = entrenadorId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.experiencia = experiencia;
        this.descripcion = descripcion;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
