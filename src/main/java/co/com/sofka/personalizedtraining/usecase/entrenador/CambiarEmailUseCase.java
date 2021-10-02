package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.entrenador.Entrenador;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.cambiarEmail;

public class CambiarEmailUseCase extends UseCase<RequestCommand<cambiarEmail>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<cambiarEmail> cambiarEmailRequestCommand) {
        var command = cambiarEmailRequestCommand.getCommand();
        var entrenador = Entrenador.from(command.getEntrenadorId(),retrieveEvents(command.getEntrenadorId().value()));
        entrenador.cambiarEmail(command.getEmail());
        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
