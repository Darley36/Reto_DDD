package co.com.sofka.personalizedtraining.domain.entrenador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;

public class cambiarNombre extends Command {
    private final EntrenadorId entrenadorId;
    private final Nombre nombre;

    public cambiarNombre(EntrenadorId entrenadorId, Nombre nombre) {
        this.entrenadorId = entrenadorId;
        this.nombre = nombre;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
