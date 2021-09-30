package co.com.sofka.personalizedtraining.domain.grupo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;
import co.com.sofka.personalizedtraining.domain.grupo.values.GrupoId;

public class CrearGrupo extends Command {
    private final GrupoId entityId;
    private final Apelativo apelativo;

    public CrearGrupo(GrupoId entityId, Apelativo apelativo) {
        this.entityId = entityId;
        this.apelativo = apelativo;
    }

    public GrupoId getEntityId() {
        return entityId;
    }

    public Apelativo getApelativo() {
        return apelativo;
    }
}
