package co.com.sofka.personalizedtraining.domain.grupo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

public class EquipoEntrenamientoCreado extends DomainEvent {
    private final EquipoEntrenamientoId equipoEntrenamientoId;
    private final Procedencia procedencia;
    private final Instrucciones instrucciones;
    private final Cantidad cantidad;
    private final Material material;

    public EquipoEntrenamientoCreado(EquipoEntrenamientoId equipoEntrenamientoId, Procedencia procedencia, Instrucciones instrucciones, Cantidad cantidad, Material material) {
        super("sofka.grupo.equipoentrenamientocreado");
        this.equipoEntrenamientoId = equipoEntrenamientoId;
        this.procedencia = procedencia;
        this.instrucciones = instrucciones;
        this.cantidad = cantidad;
        this.material = material;
    }

    public EquipoEntrenamientoId getEquipoEntrenamientoId() {
        return equipoEntrenamientoId;
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
