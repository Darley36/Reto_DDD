package co.com.sofka.personalizedtraining.domain.grupo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;
import co.com.sofka.personalizedtraining.domain.grupo.values.GrupoId;

public class cambiarApelativo extends Command {
    private final GrupoId grupoId;
    private final Apelativo apelativo;

    public cambiarApelativo(GrupoId grupoId, Apelativo apelativo) {
        this.grupoId = grupoId;
        this.apelativo = apelativo;
    }

    public GrupoId getGrupoId() {
        return grupoId;
    }

    public Apelativo getApelativo() {
        return apelativo;
    }
}
