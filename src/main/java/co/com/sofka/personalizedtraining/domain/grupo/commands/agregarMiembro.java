package co.com.sofka.personalizedtraining.domain.grupo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

public class agregarMiembro extends Command {
    private final GrupoId grupoId;
    private final MiembroId entityId;
    private final Nombre nombre;
    private final Email email;
    private final Residencia residencia;
    private final DatosFisicos datosFisicos;

    public agregarMiembro(GrupoId grupoId, MiembroId entityId, Nombre nombre, Email email, Residencia residencia, DatosFisicos datosFisicos) {
        this.grupoId = grupoId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.email = email;
        this.residencia = residencia;
        this.datosFisicos = datosFisicos;
    }

    public GrupoId getGrupoId() {
        return grupoId;
    }

    public MiembroId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public DatosFisicos getDatosFisicos() {
        return datosFisicos;
    }
}
