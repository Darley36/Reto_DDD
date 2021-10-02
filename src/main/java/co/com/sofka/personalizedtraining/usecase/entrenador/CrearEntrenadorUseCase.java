package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.personalizedtraining.domain.entrenador.Entrenador;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.CrearEntrenador;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Email;
import co.com.sofka.personalizedtraining.domain.grupo.Grupo;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;

public class CrearEntrenadorUseCase extends UseCase<RequestCommand<CrearEntrenador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEntrenador> crearEntrenadorRequestCommand) {
        var command = crearEntrenadorRequestCommand.getCommand();
        Entrenador entrenador;
        if(command.getEmail().value() == "") {
            entrenador = new Entrenador(
                    command.getEntrenadorId(),
                    command.getNombre(),
                    new Email("EmailDefecto@email.com"));

        }else{
            entrenador = new Entrenador(
                    command.getEntrenadorId(),
                    command.getNombre(),
                    command.getEmail());
        }
        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
