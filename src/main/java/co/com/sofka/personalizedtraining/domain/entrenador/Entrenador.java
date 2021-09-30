package co.com.sofka.personalizedtraining.domain.entrenador;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.events.EntrenadorCreado;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Email;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;

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
}
