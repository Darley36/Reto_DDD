package co.com.sofka.personalizedtraining.domain.entrenador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Email;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;

public class CrearEntrenador extends Command {
    private final EntrenadorId entrenadorId;
    private final Nombre nombre;
    private final Email email;

    public CrearEntrenador(EntrenadorId entrenadorId, Nombre nombre, Email email) {
        this.entrenadorId = entrenadorId;
        this.nombre = nombre;
        this.email = email;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }
}
