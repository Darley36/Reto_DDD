package co.com.sofka.personalizedtraining.domain.entrenador;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.entrenador.values.ConocimientoId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.DatosClave;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Descripcion;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Tema;

public class Conocimiento extends Entity<ConocimientoId> {
    private final Descripcion descripcion;
    private final DatosClave datosClave;
    private final Tema tema;

    public Conocimiento(ConocimientoId entityId, Descripcion descripcion, DatosClave datosClave, Tema tema) {
        super(entityId);
        this.descripcion = descripcion;
        this.datosClave = datosClave;
        this.tema = tema;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public DatosClave datosClave() {
        return datosClave;
    }

    public Tema tema() {
        return tema;
    }
}
