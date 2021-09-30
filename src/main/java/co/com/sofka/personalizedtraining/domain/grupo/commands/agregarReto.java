package co.com.sofka.personalizedtraining.domain.grupo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

public class agregarReto extends Command {
    private final GrupoId grupoId;
    private final RetoId entityId;
    private final Descripcion descripcion;
    private final Duracion duracion;
    private final FechaEjecucion fechaEjecucion;
    private final Dificultad dificultad;
    private final Estado estado;

    public agregarReto(GrupoId grupoId, RetoId entityId, Descripcion descripcion, Duracion duracion, FechaEjecucion fechaEjecucion, Dificultad dificultad, Estado estado) {
        this.grupoId = grupoId;
        this.entityId = entityId;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaEjecucion = fechaEjecucion;
        this.dificultad = dificultad;
        this.estado = estado;
    }

    public GrupoId getGrupoId() {
        return grupoId;
    }

    public RetoId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public FechaEjecucion getFechaEjecucion() {
        return fechaEjecucion;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public Estado getEstado() {
        return estado;
    }
}
