package co.com.sofka.personalizedtraining.domain.entrenador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.FuncionId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;

public class actualizarNombreFuncion extends Command {
    private final EntrenadorId entrenadorId;
    private final FuncionId entityId;
    private final Nombre nombre;

    public actualizarNombreFuncion(EntrenadorId entrenadorId, FuncionId entityId, Nombre nombre) {
        this.entrenadorId = entrenadorId;
        this.entityId = entityId;
        this.nombre = nombre;
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
}
