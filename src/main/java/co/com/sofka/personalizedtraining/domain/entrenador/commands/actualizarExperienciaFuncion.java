package co.com.sofka.personalizedtraining.domain.entrenador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Experiencia;
import co.com.sofka.personalizedtraining.domain.entrenador.values.FuncionId;

public class actualizarExperienciaFuncion extends Command {
    private final EntrenadorId entrenadorId;
    private final FuncionId entityId;
    private final Experiencia experiencia;

    public actualizarExperienciaFuncion(EntrenadorId entrenadorId, FuncionId entityId, Experiencia experiencia) {
        this.entrenadorId = entrenadorId;
        this.entityId = entityId;
        this.experiencia = experiencia;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }
}
