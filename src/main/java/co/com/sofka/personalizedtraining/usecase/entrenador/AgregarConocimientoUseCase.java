package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.entrenador.Entrenador;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.agregarConocimiento;

public class AgregarConocimientoUseCase extends UseCase<RequestCommand<agregarConocimiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<agregarConocimiento> agregarConocimientoRequestCommand) {
        var command = agregarConocimientoRequestCommand.getCommand();
        var entrenador = Entrenador.from(command.getEntrenadorId(),retrieveEvents());
        entrenador.agregarConocimiento(
                command.getEntityId(),
                command.getDescripcion(),
                command.getDatosClave(),
                command.getTema());

        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
