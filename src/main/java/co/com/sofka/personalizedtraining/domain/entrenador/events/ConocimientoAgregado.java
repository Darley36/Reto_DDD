package co.com.sofka.personalizedtraining.domain.entrenador.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.ConocimientoId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.DatosClave;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Descripcion;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Tema;

public class ConocimientoAgregado extends DomainEvent {
    private final ConocimientoId conocimientoId;
    private final Descripcion descripcion;
    private final DatosClave datosClave;
    private final Tema tema;

    public ConocimientoAgregado(ConocimientoId conocimientoId, Descripcion descripcion, DatosClave datosClave, Tema tema) {
        super("sofka.entrenador,conocimientoagregado");
        this.conocimientoId = conocimientoId;
        this.descripcion = descripcion;
        this.datosClave = datosClave;
        this.tema = tema;
    }

    public ConocimientoId getConocimientoId() {
        return conocimientoId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public DatosClave getDatosClave() {
        return datosClave;
    }

    public Tema getTema() {
        return tema;
    }
}
