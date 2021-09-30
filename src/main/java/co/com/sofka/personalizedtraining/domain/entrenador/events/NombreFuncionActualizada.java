package co.com.sofka.personalizedtraining.domain.entrenador.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.FuncionId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;

public class NombreFuncionActualizada extends DomainEvent {
    private final FuncionId funcionId;
    private final Nombre nombre;

    public NombreFuncionActualizada(FuncionId funcionId, Nombre nombre) {
        super("sofka.entrenador.nombrefuncionactualizada");
        this.funcionId = funcionId;
        this.nombre = nombre;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
