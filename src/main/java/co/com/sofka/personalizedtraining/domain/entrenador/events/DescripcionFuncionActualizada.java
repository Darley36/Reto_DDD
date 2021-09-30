package co.com.sofka.personalizedtraining.domain.entrenador.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Descripcion;
import co.com.sofka.personalizedtraining.domain.entrenador.values.FuncionId;

public class DescripcionFuncionActualizada extends DomainEvent {
    private final FuncionId funcionId;
    private final Descripcion descripcion;

    public DescripcionFuncionActualizada(FuncionId funcionId, Descripcion descripcion) {
        super("sofka.entrenador.descripcionfuncionactualizada");
        this.funcionId = funcionId;
        this.descripcion = descripcion;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
