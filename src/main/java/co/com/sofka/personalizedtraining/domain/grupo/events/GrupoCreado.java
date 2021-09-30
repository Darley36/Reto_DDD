package co.com.sofka.personalizedtraining.domain.grupo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;

public class GrupoCreado extends DomainEvent {
    private final Apelativo apelativo;

    public GrupoCreado(Apelativo apelativo) {
        super("sofka.grupo,grupocreado");
        this.apelativo = apelativo;
    }

    public Apelativo getApelativo() {
        return apelativo;
    }
}
