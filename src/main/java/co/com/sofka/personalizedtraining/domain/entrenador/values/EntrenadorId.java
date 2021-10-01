package co.com.sofka.personalizedtraining.domain.entrenador.values;

import co.com.sofka.domain.generic.Identity;

public class EntrenadorId extends Identity {
    public EntrenadorId(){}

    public EntrenadorId(String id){
        super(id);
    }
    public static EntrenadorId of(String id){
        return new EntrenadorId(id);
    }
}
