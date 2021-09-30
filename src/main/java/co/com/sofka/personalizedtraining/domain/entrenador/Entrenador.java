package co.com.sofka.personalizedtraining.domain.entrenador;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.events.*;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Entrenador extends AggregateEvent<EntrenadorId> {
    protected Nombre nombre;
    protected Email email;
    protected Set<Conocimiento> conocimientos;
    protected Set<Funcion> funciones;
    protected Set<Rutina> rutinas;

    public Entrenador(EntrenadorId entityId, Nombre nombre, Email email) {
        super(entityId);
        appendChange(new EntrenadorCreado(nombre,email)).apply();
    }

    private Entrenador(EntrenadorId entityId){
        super(entityId);
        subscribe(new EntrenadorChange(this));
    }

    public static Entrenador from(EntrenadorId entrenadorId, List<DomainEvent> events){
        var entrenador = new Entrenador(entrenadorId);
        events.forEach(entrenador::applyEvent);
        return entrenador;
    }

    public void agregarFuncion(FuncionId entityId, Nombre nombre, Capacidad capacidad, Experiencia experiencia, Descripcion descripcion){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(capacidad);
        Objects.requireNonNull(experiencia);
        Objects.requireNonNull(descripcion);
        appendChange(new FuncionAgregada(entityId,nombre,capacidad,experiencia,descripcion)).apply();
    }

    public void agregarRutina(RutinaId entityId, Serie serie, Afectacion afectacion, Caracteristica caracteristica){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(serie);
        Objects.requireNonNull(afectacion);
        Objects.requireNonNull(caracteristica);
        appendChange(new RutinaAgregada(entityId,serie,afectacion,caracteristica)).apply();
    }

    public void agregarConocimiento(ConocimientoId entityId, Descripcion descripcion, DatosClave datosClave, Tema tema){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(datosClave);
        Objects.requireNonNull(tema);
        appendChange(new ConocimientoAgregado(entityId,descripcion,datosClave,tema)).apply();
    }

    public void cambiarNombre(Nombre nombre){
        appendChange(new NombreCambiado(nombre)).apply();
    }

    public void cambiarEmail(Email email){
        appendChange(new EmailCambiado(email)).apply();
    }

    public void actualizarNombreFuncion(FuncionId entityId, Nombre nombre){
        appendChange(new NombreFuncionActualizada(entityId,nombre)).apply();
    }

    public void actualizarCapacidadFuncion(FuncionId entityId, Capacidad capacidad){
        appendChange(new CapacidadFuncionActualizada(entityId,capacidad)).apply();
    }

    public void actualizarExperienciaFuncion(FuncionId entityId, Experiencia experiencia){
        appendChange(new ExperienciaFuncionActualizada(entityId,experiencia)).apply();
    }

    public void actualizarDescripcionFuncion(FuncionId entityId, Descripcion descripcion){
        appendChange(new DescripcionFuncionActualizada(entityId,descripcion)).apply();
    }

    protected Optional<Funcion> getFuncionPorId(FuncionId funcionId){
        return funciones()
                .stream()
                .filter(funcion -> funcion.identity().equals(entityId))
                .findFirst();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Email email() {
        return email;
    }

    public Set<Conocimiento> conocimientos() {
        return conocimientos;
    }

    public Set<Funcion> funciones() {
        return funciones;
    }

    public Set<Rutina> rutinas() {
        return rutinas;
    }
}
