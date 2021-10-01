package co.com.sofka.personalizedtraining.domain.grupo.values;

import co.com.sofka.domain.generic.Identity;

public class EquipoEntrenamientoId extends Identity {
    public EquipoEntrenamientoId(){}

    public EquipoEntrenamientoId(String id){
        super(id);
    }
    public static EquipoEntrenamientoId of(String id){
        return new EquipoEntrenamientoId(id);
    }
}
