package co.com.sofka.personalizedtraining.usecase.grupo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.grupo.Grupo;
import co.com.sofka.personalizedtraining.domain.grupo.commands.agregarReto;

public class AgregarRetoUseCase extends UseCase<RequestCommand<agregarReto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<agregarReto> agregarRetoRequestCommand) {
        var command = agregarRetoRequestCommand.getCommand();
        var grupo = Grupo.from(command.getGrupoId(),retrieveEvents());
        grupo.agregarReto(
                command.getEntityId(),
                command.getDescripcion(),
                command.getDuracion(),
                command.getFechaEjecucion(),
                command.getDificultad(),
                command.getEstado());

        emit().onResponse(new ResponseEvents(grupo.getUncommittedChanges()));
    }
}
