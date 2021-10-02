package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.entrenador.Entrenador;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.cambiarNombre;
import co.com.sofka.personalizedtraining.domain.grupo.Grupo;

public class CambiarNombreUseCase extends UseCase<RequestCommand<cambiarNombre>,ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<cambiarNombre> cambiarNombreRequestCommand) {
        var command = cambiarNombreRequestCommand.getCommand();
        var entrenador = Entrenador.from(command.getEntrenadorId(),retrieveEvents(command.getEntrenadorId().value()));
        entrenador.cambiarNombre(command.getNombre());
        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
