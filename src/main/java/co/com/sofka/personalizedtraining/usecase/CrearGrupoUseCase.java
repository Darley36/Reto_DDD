package co.com.sofka.personalizedtraining.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.grupo.Grupo;
import co.com.sofka.personalizedtraining.domain.grupo.commands.CrearGrupo;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;


public class CrearGrupoUseCase extends UseCase<RequestCommand<CrearGrupo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearGrupo> crearGrupoRequestCommand) {
        var command = crearGrupoRequestCommand.getCommand();
        Grupo grupo;
        if(command.getApelativo().value().length() < 12) {
            grupo = new Grupo(
                    command.getEntityId(),
                    new Apelativo("ApelativoDefecto")
            );
        }else{
            grupo = new Grupo(
                    command.getEntityId(),
                    command.getApelativo()
            );
        }
        emit().onResponse(new ResponseEvents(grupo.getUncommittedChanges()));
    }

}
