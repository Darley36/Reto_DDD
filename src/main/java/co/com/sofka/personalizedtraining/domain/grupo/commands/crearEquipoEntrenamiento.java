package co.com.sofka.personalizedtraining.domain.grupo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

public class crearEquipoEntrenamiento extends Command {
    private final GrupoId grupoId;
    private final EquipoEntrenamientoId entityId;
    private final Procedencia procedencia;
    private final Instrucciones instrucciones;
    private final Cantidad cantidad;
    private final Material material;

    public crearEquipoEntrenamiento(GrupoId grupoId, EquipoEntrenamientoId entityId, Procedencia procedencia, Instrucciones instrucciones, Cantidad cantidad, Material material) {
        this.grupoId = grupoId;
        this.entityId = entityId;
        this.procedencia = procedencia;
        this.instrucciones = instrucciones;
        this.cantidad = cantidad;
        this.material = material;
    }

    public GrupoId getGrupoId() {
        return grupoId;
    }

    public EquipoEntrenamientoId getEntityId() {
        return entityId;
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public Instrucciones getInstrucciones() {
        return instrucciones;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public Material getMaterial() {
        return material;
    }
}
