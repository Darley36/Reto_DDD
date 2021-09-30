package co.com.sofka.personalizedtraining.domain.grupo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

public class MiembroAgregado extends DomainEvent {
    private final MiembroId miembroId;
    private final Nombre nombre;
    private final Email email;
    private final Residencia residencia;
    private final DatosFisicos datosFisicos;

    public MiembroAgregado(MiembroId miembroId, Nombre nombre, Email email, Residencia residencia, DatosFisicos datosFisicos) {
        super("sofka.grupo.miembroagregado");
        this.miembroId = miembroId;
        this.nombre = nombre;
        this.email = email;
        this.residencia = residencia;
        this.datosFisicos = datosFisicos;
    }

    public MiembroId getMiembroId() {
        return miembroId;
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
