package co.com.sofka.personalizedtraining.domain.entrenador.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Email;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;

public class cambiarEmail extends Command {
    private final EntrenadorId entrenadorId;
    private final Email email;

    public cambiarEmail(EntrenadorId entrenadorId, Email email) {
        this.entrenadorId = entrenadorId;
        this.email = email;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }

    public Email getEmail() {
        return email;
    }
}
