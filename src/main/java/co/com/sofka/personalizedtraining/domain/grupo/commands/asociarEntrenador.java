package co.com.sofka.personalizedtraining.domain.grupo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.grupo.values.GrupoId;

public class asociarEntrenador extends Command {
    private final GrupoId grupoId;
    private final EntrenadorId entrenadorId;

    public asociarEntrenador(GrupoId grupoId, EntrenadorId entrenadorId) {
        this.grupoId = grupoId;
        this.entrenadorId = entrenadorId;
    }

    public GrupoId getGrupoId() {
        return grupoId;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }
}
