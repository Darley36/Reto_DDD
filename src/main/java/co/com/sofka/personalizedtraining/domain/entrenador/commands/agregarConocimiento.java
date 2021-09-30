package co.com.sofka.personalizedtraining.domain.entrenador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;

public class agregarConocimiento extends Command {
    private final EntrenadorId entrenadorId;
    private final ConocimientoId entityId;
    private final Descripcion descripcion;
    private final DatosClave datosClave;
    private final Tema tema;

    public agregarConocimiento(EntrenadorId entrenadorId, ConocimientoId entityId, Descripcion descripcion, DatosClave datosClave, Tema tema) {
        this.entrenadorId = entrenadorId;
        this.entityId = entityId;
        this.descripcion = descripcion;
        this.datosClave = datosClave;
        this.tema = tema;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }

    public ConocimientoId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public DatosClave getDatosClave() {
        return datosClave;
    }

    public Tema getTema() {
        return tema;
    }
}
