package co.com.sofka.personalizedtraining.domain.entrenador.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Experiencia;
import co.com.sofka.personalizedtraining.domain.entrenador.values.FuncionId;

public class ExperienciaFuncionActualizada extends DomainEvent {
    private final FuncionId funcionId;
    private final Experiencia experiencia;

    public ExperienciaFuncionActualizada(FuncionId funcionId, Experiencia experiencia) {
        super("sofka.entrenador.experienciafuncionactualizada");
        this.funcionId = funcionId;
        this.experiencia = experiencia;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }
}
