package co.com.sofka.personalizedtraining.domain.entrenador;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.personalizedtraining.domain.entrenador.events.*;

public class EntrenadorChange extends EventChange {
    public EntrenadorChange(Entrenador entrenador) {

        apply((EntrenadorCreado event) -> {
            entrenador.nombre = event.getNombre();
            entrenador.email = event.getEmail();
        });

        apply((NombreCambiado event) -> {
            entrenador.nombre = event.getNombre();
        });

        apply((EmailCambiado event) -> {
            entrenador.email = event.getEmail();
        });

        apply((FuncionAgregada event) -> {
            entrenador.funciones.add(new Funcion(
                    event.getFuncionId(),
                    event.getNombre(),
                    event.getCapacidad(),
                    event.getExperiencia(),
                    event.getDescripcion()
            ));
        });

        apply((RutinaAgregada event) -> {
            entrenador.rutinas.add(new Rutina(
                    event.getRutinaId(),
                    event.getSerie(),
                    event.getAfectacion(),
                    event.getCaracteristica()
            ));
        });

        apply((ConocimientoAgregado event) -> {
            entrenador.conocimientos.add(new Conocimiento(
                    event.getConocimientoId(),
                    event.getDescripcion(),
                    event.getDatosClave(),
                    event.getTema()
            ));
        });

        apply((CapacidadFuncionActualizada event) -> {
            var funcion = entrenador.getFuncionPorId(event.getFuncionId()).orElseThrow(() -> new IllegalArgumentException("No se encuentra la funcion"));
            funcion.actualizarCapacidad(event.getCapacidad());
        });

        apply((DescripcionFuncionActualizada event) -> {
            var funcion = entrenador.getFuncionPorId(event.getFuncionId()).orElseThrow(() -> new IllegalArgumentException("No se encuentra la funcion"));
            funcion.actualizarDescripcion(event.getDescripcion());
        });

        apply((ExperienciaFuncionActualizada event) -> {
            var funcion = entrenador.getFuncionPorId(event.getFuncionId()).orElseThrow(() -> new IllegalArgumentException("No se encuentra la funcion"));
            funcion.actualizarExperiencia(event.getExperiencia());
        });

        apply((NombreFuncionActualizada event) -> {
            var funcion = entrenador.getFuncionPorId(event.getFuncionId()).orElseThrow(() -> new IllegalArgumentException("No se encuentra la funcion"));
            funcion.actualizarNombre(event.getNombre());
        });

    }
}
