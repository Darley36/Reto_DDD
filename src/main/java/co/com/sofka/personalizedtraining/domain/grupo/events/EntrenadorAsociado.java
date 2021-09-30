package co.com.sofka.personalizedtraining.domain.grupo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;

public class EntrenadorAsociado extends DomainEvent {
    private final EntrenadorId entrenadorId;
    public EntrenadorAsociado(EntrenadorId entrenadorId) {
        super("sofka.grupo.entrenadorasociado");
        this.entrenadorId = entrenadorId;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }
}
