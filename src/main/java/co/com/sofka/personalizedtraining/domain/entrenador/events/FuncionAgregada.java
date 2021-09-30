package co.com.sofka.personalizedtraining.domain.entrenador.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;

public class FuncionAgregada extends DomainEvent {
    private final FuncionId funcionId;
    private final Nombre nombre;
    private final Capacidad capacidad;
    private final Experiencia experiencia;
    private final Descripcion descripcion;

    public FuncionAgregada(FuncionId funcionId, Nombre nombre, Capacidad capacidad, Experiencia experiencia, Descripcion descripcion) {
        super("sofka.entrenador.funcionagregada");
        this.funcionId = funcionId;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.experiencia = experiencia;
        this.descripcion = descripcion;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
