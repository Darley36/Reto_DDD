package co.com.sofka.personalizedtraining.domain.grupo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

public class Miembro extends Entity<MiembroId> {
    private final Nombre nombre;
    private final Email email;
    private final Residencia residencia;
    private final DatosFisicos datosFisicos;

    public Miembro(MiembroId entityId, Nombre nombre, Email email, Residencia residencia, DatosFisicos datosFisicos) {
        super(entityId);
        this.nombre = nombre;
        this.email = email;
        this.residencia = residencia;
        this.datosFisicos = datosFisicos;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Email email() {
        return email;
    }

    public Residencia residencia() {
        return residencia;
    }

    public DatosFisicos datosFisicos() {
        return datosFisicos;
    }
}
