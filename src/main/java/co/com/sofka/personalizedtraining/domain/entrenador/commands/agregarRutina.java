package co.com.sofka.personalizedtraining.domain.entrenador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;

public class agregarRutina extends Command {
    private final EntrenadorId entrenadorId;
    private final RutinaId entityId;
    private final Serie serie;
    private final Afectacion afectacion;
    private final Caracteristica caracteristica;

    public agregarRutina(EntrenadorId entrenadorId, RutinaId entityId, Serie serie, Afectacion afectacion, Caracteristica caracteristica) {
        this.entrenadorId = entrenadorId;
        this.entityId = entityId;
        this.serie = serie;
        this.afectacion = afectacion;
        this.caracteristica = caracteristica;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }

    public RutinaId getEntityId() {
        return entityId;
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
