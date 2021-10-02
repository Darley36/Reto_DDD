package co.com.sofka.personalizedtraining.usecase.grupo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.grupo.Grupo;
import co.com.sofka.personalizedtraining.domain.grupo.Miembro;
import co.com.sofka.personalizedtraining.domain.grupo.commands.agregarMiembro;

public class AgregarMiembroUseCase extends UseCase<RequestCommand<agregarMiembro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<agregarMiembro> agregarMiembroRequestCommand) {
        var command = agregarMiembroRequestCommand.getCommand();
        var grupo = Grupo.from(command.getGrupoId(),retrieveEvents(command.getGrupoId().value()));
        grupo.agregarMiembro(command.getEntityId(),
                command.getNombre(),
                command.getEmail(),
                command.getResidencia(),
                command.getDatosFisicos());

        emit().onResponse(new ResponseEvents(grupo.getUncommittedChanges()));

    }
}
