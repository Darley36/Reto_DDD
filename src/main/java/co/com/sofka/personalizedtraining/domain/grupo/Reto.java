package co.com.sofka.personalizedtraining.domain.grupo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

import java.util.Objects;

public class Reto extends Entity<RetoId> {
    private Descripcion descripcion;
    private Duracion duracion;
    private FechaEjecucion fechaEjecucion;
    private Dificultad dificultad;
    private Estado estado;

    public Reto(RetoId entityId, Descripcion descripcion, Duracion duracion, FechaEjecucion fechaEjecucion, Dificultad dificultad, Estado estado) {
        super(entityId);
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaEjecucion = fechaEjecucion;
        this.dificultad = dificultad;
        this.estado = estado;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public void actualizarDuracion(Duracion duracion){
        this.duracion = Objects.requireNonNull(duracion);
    }

    public void actualizarFechaEjecucion(FechaEjecucion fechaEjecucion){
        this.fechaEjecucion = Objects.requireNonNull(fechaEjecucion);
    }

    public void actualizarDificultad(Dificultad dificultad){
        this.dificultad = Objects.requireNonNull(dificultad);
    }

    public void actualizarEstado(Estado estado){
        this.estado = Objects.requireNonNull(estado);
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
