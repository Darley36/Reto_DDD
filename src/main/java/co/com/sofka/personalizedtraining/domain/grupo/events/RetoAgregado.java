package co.com.sofka.personalizedtraining.domain.grupo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

public class RetoAgregado extends DomainEvent {
    private final RetoId retoId;
    private final Descripcion descripcion;
    private final Duracion duracion;
    private final FechaEjecucion fechaEjecucion;
    private final Dificultad dificultad;
    private final Estado estado;

    public RetoAgregado(RetoId retoId, Descripcion descripcion, Duracion duracion, FechaEjecucion fechaEjecucion, Dificultad dificultad, Estado estado) {
        super("sofka.grupo.retoagregado");
        this.retoId = retoId;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaEjecucion = fechaEjecucion;
        this.dificultad = dificultad;
        this.estado = estado;
    }

    public RetoId getRetoId() {
        return retoId;
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
