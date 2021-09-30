package co.com.sofka.personalizedtraining.domain.entrenador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Capacidad;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.FuncionId;

public class actualizarCapacidadFuncion extends Command {
    private final EntrenadorId entrenadorId;
    private final FuncionId entityId;
    private final Capacidad capacidad;

    public actualizarCapacidadFuncion(EntrenadorId entrenadorId, FuncionId entityId, Capacidad capacidad) {
        this.entrenadorId = entrenadorId;
        this.entityId = entityId;
        this.capacidad = capacidad;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
