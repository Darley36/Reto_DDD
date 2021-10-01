package co.com.sofka.personalizedtraining.domain.grupo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.grupo.events.*;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Grupo extends AggregateEvent<GrupoId> {
    protected Apelativo apelativo;
    protected EquipoEntrenamiento equipoEntrenamiento;
    protected Set<Reto> retos;
    protected Set<Miembro> miembros;
    protected EntrenadorId entrenadorId;

    public Grupo(GrupoId entityId, Apelativo apelativo) {
        super(entityId);
        appendChange(new GrupoCreado(apelativo)).apply();
    }

    private Grupo(GrupoId entityId){
        super(entityId);
        subscribe(new GrupoChange(this));
    }

    public static Grupo from(GrupoId grupoId, List<DomainEvent> events){
        var grupo = new Grupo(grupoId);
        events.forEach(grupo::applyEvent);
        return grupo;
    }

    public void cambiarApelativo(Apelativo apelativo){
        appendChange(new ApelativoCambiado(apelativo)).apply();
    }

    public void asociarEntrenador(EntrenadorId entrenadorId){
        appendChange(new EntrenadorAsociado(entrenadorId)).apply();
    }

    public void crearEquipoEntrenamiento(EquipoEntrenamientoId entityId, Procedencia procedencia, Instrucciones instrucciones, Cantidad cantidad, Material material){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(procedencia);
        Objects.requireNonNull(instrucciones);
        Objects.requireNonNull(cantidad);
        Objects.requireNonNull(material);
        appendChange(new EquipoEntrenamientoCreado(entityId,procedencia,instrucciones,cantidad,material)).apply();
    }

    public void agregarMiembro(MiembroId entityId, Nombre nombre, Email email, Residencia residencia, DatosFisicos datosFisicos){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(email);
        Objects.requireNonNull(residencia);
        Objects.requireNonNull(datosFisicos);
        appendChange(new MiembroAgregado(entityId,nombre,email,residencia,datosFisicos)).apply();
    }

    public void agregarReto(RetoId entityId, Descripcion descripcion, Duracion duracion, FechaEjecucion fechaEjecucion, Dificultad dificultad, Estado estado){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(duracion);
        Objects.requireNonNull(fechaEjecucion);
        Objects.requireNonNull(dificultad);
        Objects.requireNonNull(estado);
        appendChange(new RetoAgregado(entityId,descripcion,duracion,fechaEjecucion,dificultad,estado)).apply();
    }

    public void enviarAlerta(String mensaje) {
        appendChange(new MensajeEnviado(mensaje)).apply();
    }
}
