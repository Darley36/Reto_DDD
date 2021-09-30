package co.com.sofka.personalizedtraining.domain.entrenador;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;

public class Rutina extends Entity<RutinaId> {
    private final Serie serie;
    private final Afectacion afectacion;
    private final Caracteristica caracteristica;

    public Rutina(RutinaId entityId, Serie serie, Afectacion afectacion, Caracteristica caracteristica) {
        super(entityId);
        this.serie = serie;
        this.afectacion = afectacion;
        this.caracteristica = caracteristica;
    }

    public Serie serie() {
        return serie;
    }

    public Afectacion afectacion() {
        return afectacion;
    }

    public Caracteristica caracteristica() {
        return caracteristica;
    }
}
