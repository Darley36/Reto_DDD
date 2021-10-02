package co.com.sofka.personalizedtraining.usecase.grupo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.grupo.Grupo;
import co.com.sofka.personalizedtraining.domain.grupo.commands.cambiarApelativo;
import co.com.sofka.personalizedtraining.domain.grupo.commands.crearEquipoEntrenamiento;

public class CrearEquipoEntrenamientoUseCase extends UseCase<RequestCommand<crearEquipoEntrenamiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<crearEquipoEntrenamiento> crearEquipoEntrenamientoRequestCommand) {
        var command = crearEquipoEntrenamientoRequestCommand.getCommand();
        var grupo = Grupo.from(command.getGrupoId(),retrieveEvents(command.getGrupoId().value()));
        grupo.crearEquipoEntrenamiento(
                command.getEntityId(),
                command.getProcedencia(),
                command.getInstrucciones(),
                command.getCantidad(),
                command.getMaterial());

        emit().onResponse(new ResponseEvents(grupo.getUncommittedChanges()));
    }
}
