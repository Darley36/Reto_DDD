package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.entrenador.Entrenador;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.agregarFuncion;

public class AgregarFuncionUseCase extends UseCase<RequestCommand<agregarFuncion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<agregarFuncion> agregarFuncionRequestCommand) {
        var command = agregarFuncionRequestCommand.getCommand();
        var entrenador = Entrenador.from(command.getEntrenadorId(),retrieveEvents());
        entrenador.agregarFuncion(
                command.getEntityId(),
                command.getNombre(),
                command.getCapacidad(),
                command.getExperiencia(),
                command.getDescripcion());

        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
