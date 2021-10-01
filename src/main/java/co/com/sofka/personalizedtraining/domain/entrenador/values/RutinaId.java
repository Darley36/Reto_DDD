package co.com.sofka.personalizedtraining.domain.entrenador.values;

import co.com.sofka.domain.generic.Identity;

public class RutinaId extends Identity {
    public RutinaId(){}

    public RutinaId(String id){
        super(id);
    }
    public static RutinaId of(String id){
        return new RutinaId(id);
    }
}
