package co.com.sofka.personalizedtraining.usecase.grupo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.grupo.Grupo;
import co.com.sofka.personalizedtraining.domain.grupo.commands.cambiarApelativo;

public class CambiarApelativoUseCase extends UseCase<RequestCommand<cambiarApelativo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<cambiarApelativo> cambiarApelativoRequestCommand) {
        var command = cambiarApelativoRequestCommand.getCommand();
        var grupo = Grupo.from(command.getGrupoId(),retrieveEvents(command.getGrupoId().value()));
        grupo.cambiarApelativo(command.getApelativo());
        emit().onResponse(new ResponseEvents(grupo.getUncommittedChanges()));
    }
}
