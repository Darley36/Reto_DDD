package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.entrenador.Entrenador;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.agregarRutina;
import co.com.sofka.personalizedtraining.domain.grupo.Grupo;
import co.com.sofka.personalizedtraining.domain.grupo.commands.agregarReto;

public class AgregarRutinaUseCase extends UseCase<RequestCommand<agregarRutina>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<agregarRutina> agregarRutinaRequestCommand) {

            var command = agregarRutinaRequestCommand.getCommand();
            var entrenador = Entrenador.from(command.getEntrenadorId(),retrieveEvents());
            entrenador.agregarRutina(
                    command.getEntityId(),
                    command.getSerie(),
                    command.getAfectacion(),
                    command.getCaracteristica());

            emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));

    }
}
