package co.com.sofka.personalizedtraining.domain.entrenador;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;

import java.util.Objects;

public class Rutina extends Entity<RutinaId> {
    private Serie serie;
    private Afectacion afectacion;
    private Caracteristica caracteristica;

    public Rutina(RutinaId entityId, Serie serie, Afectacion afectacion, Caracteristica caracteristica) {
        super(entityId);
        this.serie = serie;
        this.afectacion = afectacion;
        this.caracteristica = caracteristica;
    }

    public void actualizarSerie(Serie serie){
        this.serie = Objects.requireNonNull(serie);
    }

    public void actualizarAfectacion(Afectacion afectacion){
        this.afectacion = Objects.requireNonNull(afectacion);
    }

    public void actualizarCaracteristica(Caracteristica caracteristica){
        this.caracteristica = Objects.requireNonNull(caracteristica);
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
