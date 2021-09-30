package co.com.sofka.personalizedtraining.domain.grupo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

public class EquipoEntrenamiento extends Entity<EquipoEntrenamientoId> {
    private final Procedencia procedencia;
    private final Instrucciones instrucciones;
    private final Cantidad cantidad;
    private final Material material;

    public EquipoEntrenamiento(EquipoEntrenamientoId entityId, Procedencia procedencia, Instrucciones instrucciones, Cantidad cantidad, Material material) {
        super(entityId);
        this.procedencia = procedencia;
        this.instrucciones = instrucciones;
        this.cantidad = cantidad;
        this.material = material;
    }

    public Procedencia procedencia() {
        return procedencia;
    }

    public Instrucciones instrucciones() {
        return instrucciones;
    }

    public Cantidad cantidad() {
        return cantidad;
    }

    public Material material() {
        return material;
    }
}
