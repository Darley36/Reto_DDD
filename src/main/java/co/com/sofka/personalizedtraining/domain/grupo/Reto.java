package co.com.sofka.personalizedtraining.domain.grupo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

public class Reto extends Entity<RetoId> {
    private final Descripcion descripcion;
    private final Duracion duracion;
    private final FechaEjecucion fechaEjecucion;
    private final Dificultad dificultad;
    private final Estado estado;

    public Reto(RetoId entityId, Descripcion descripcion, Duracion duracion, FechaEjecucion fechaEjecucion, Dificultad dificultad, Estado estado) {
        super(entityId);
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaEjecucion = fechaEjecucion;
        this.dificultad = dificultad;
        this.estado = estado;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Duracion duracion() {
        return duracion;
    }

    public FechaEjecucion fechaEjecucion() {
        return fechaEjecucion;
    }

    public Dificultad dificultad() {
        return dificultad;
    }

    public Estado estado() {
        return estado;
    }
}
