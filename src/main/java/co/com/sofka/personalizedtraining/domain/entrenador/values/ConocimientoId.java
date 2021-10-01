package co.com.sofka.personalizedtraining.domain.entrenador.values;

import co.com.sofka.domain.generic.Identity;

public class ConocimientoId extends Identity {
    public ConocimientoId(){}

    public ConocimientoId(String id){
        super(id);
    }
    public static ConocimientoId of(String id){
        return new ConocimientoId(id);
    }
}
