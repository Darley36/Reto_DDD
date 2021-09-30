package co.com.sofka.personalizedtraining.domain.entrenador.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Capacidad;
import co.com.sofka.personalizedtraining.domain.entrenador.values.FuncionId;

public class CapacidadFuncionActualizada extends DomainEvent {
    private final FuncionId funcionId;
    private final Capacidad capacidad;

    public CapacidadFuncionActualizada(FuncionId funcionId, Capacidad capacidad) {
        super("sofka.entrenador.capacidadfuncionactualizada");
        this.funcionId = funcionId;
        this.capacidad = capacidad;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
