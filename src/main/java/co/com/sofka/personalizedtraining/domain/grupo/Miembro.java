package co.com.sofka.personalizedtraining.domain.grupo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

import java.util.Objects;

public class Miembro extends Entity<MiembroId> {
    private Nombre nombre;
    private Email email;
    private Residencia residencia;
    private DatosFisicos datosFisicos;

    public Miembro(MiembroId entityId, Nombre nombre, Email email, Residencia residencia, DatosFisicos datosFisicos) {
        super(entityId);
        this.nombre = nombre;
        this.email = email;
        this.residencia = residencia;
        this.datosFisicos = datosFisicos;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarEmail(Email email){
        this.email = Objects.requireNonNull(email);
    }

    public void actualizarResidencia(Residencia residencia){
        this.residencia = Objects.requireNonNull(residencia);
    }

    public void actualizarDatosFisicos(DatosFisicos datosFisicos){
        this.datosFisicos = Objects.requireNonNull(datosFisicos);
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
