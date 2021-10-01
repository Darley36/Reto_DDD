package co.com.sofka.personalizedtraining.domain.grupo.values;

import co.com.sofka.domain.generic.Identity;

public class RetoId extends Identity {
    public RetoId(){}

    public RetoId(String id){
        super(id);
    }
    public static RetoId of(String id){
        return new RetoId(id);
    }
}
