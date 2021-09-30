package co.com.sofka.personalizedtraining.domain.entrenador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Descripcion;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.FuncionId;

public class actualizarDescripcionFuncion extends Command {
    private final EntrenadorId entrenadorId;
    private final FuncionId entityId;
    private final Descripcion descripcion;

    public actualizarDescripcionFuncion(EntrenadorId entrenadorId, FuncionId entityId, Descripcion descripcion) {
        this.entrenadorId = entrenadorId;
        this.entityId = entityId;
        this.descripcion = descripcion;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
