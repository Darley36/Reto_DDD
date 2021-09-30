package co.com.sofka.personalizedtraining.domain.entrenador;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.entrenador.values.ConocimientoId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.DatosClave;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Descripcion;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Tema;

import java.util.Objects;

public class Conocimiento extends Entity<ConocimientoId> {
    private Descripcion descripcion;
    private DatosClave datosClave;
    private Tema tema;

    public Conocimiento(ConocimientoId entityId, Descripcion descripcion, DatosClave datosClave, Tema tema) {
        super(entityId);
        this.descripcion = descripcion;
        this.datosClave = datosClave;
        this.tema = tema;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public void actualizarDatosClave(DatosClave datosClave){
        this.datosClave = Objects.requireNonNull(datosClave);
    }

    public void actualizarTema(Tema tema){
        this.tema = Objects.requireNonNull(tema);
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
