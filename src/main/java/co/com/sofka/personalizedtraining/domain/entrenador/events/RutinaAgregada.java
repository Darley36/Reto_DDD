package co.com.sofka.personalizedtraining.domain.entrenador.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Afectacion;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Caracteristica;
import co.com.sofka.personalizedtraining.domain.entrenador.values.RutinaId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Serie;

public class RutinaAgregada extends DomainEvent {
    private final RutinaId rutinaId;
    private final Serie serie;
    private final Afectacion afectacion;
    private final Caracteristica caracteristica;

    public RutinaAgregada(RutinaId rutinaId, Serie serie, Afectacion afectacion, Caracteristica caracteristica) {
        super("sofka.entrenador.rutinagregada");
        this.rutinaId = rutinaId;
        this.serie = serie;
        this.afectacion = afectacion;
        this.caracteristica = caracteristica;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }

    public Serie getSerie() {
        return serie;
    }

    public Afectacion getAfectacion() {
        return afectacion;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }
}
