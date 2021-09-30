package co.com.sofka.personalizedtraining.domain.grupo;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.personalizedtraining.domain.grupo.events.*;

public class GrupoChange extends EventChange {
    public GrupoChange(Grupo grupo) {

        apply((GrupoCreado event) -> {
            grupo.apelativo = event.getApelativo();
        });

        apply((ApelativoCambiado event) -> {
            grupo.apelativo = event.getApelativo();
        });

        apply((EntrenadorAsociado event) -> {
            grupo.entrenadorId = event.getEntrenadorId();
        });

        apply((EquipoEntrenamientoCreado event) -> {
            grupo.equipoEntrenamiento = new EquipoEntrenamiento(event.getEquipoEntrenamientoId(), event.getProcedencia(), event.getInstrucciones(), event.getCantidad(), event.getMaterial());
        });

        apply((MiembroAgregado event) -> {
            grupo.miembros.add(new Miembro(
                    event.getMiembroId(),
                    event.getNombre(),
                    event.getEmail(),
                    event.getResidencia(),
                    event.getDatosFisicos()
            ));
        });

        apply((RetoAgregado event) -> {
            grupo.retos.add(new Reto(
                    event.getRetoId(),
                    event.getDescripcion(),
                    event.getDuracion(),
                    event.getFechaEjecucion(),
                    event.getDificultad(),
                    event.getEstado()
            ));
        });


    }
}
