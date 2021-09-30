package co.com.sofka.personalizedtraining.domain.grupo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;

import java.util.Objects;

public class EquipoEntrenamiento extends Entity<EquipoEntrenamientoId> {
    private Procedencia procedencia;
    private Instrucciones instrucciones;
    private Cantidad cantidad;
    private Material material;

    public EquipoEntrenamiento(EquipoEntrenamientoId entityId, Procedencia procedencia, Instrucciones instrucciones, Cantidad cantidad, Material material) {
        super(entityId);
        this.procedencia = procedencia;
        this.instrucciones = instrucciones;
        this.cantidad = cantidad;
        this.material = material;
    }

    public void actualizarProcedencia(Procedencia procedencia){
        this.procedencia = Objects.requireNonNull(procedencia);
    }

    public void actualizarInstrucciones(Instrucciones instrucciones){
        this.instrucciones = Objects.requireNonNull(instrucciones);
    }

    public void actualizarCantidad(Cantidad cantidad){
        this.cantidad = Objects.requireNonNull(cantidad);
    }

    public void actualizarMaterial(Material material){
        this.material = Objects.requireNonNull(material);
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
