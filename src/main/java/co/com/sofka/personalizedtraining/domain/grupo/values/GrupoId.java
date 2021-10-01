package co.com.sofka.personalizedtraining.domain.grupo.values;

import co.com.sofka.domain.generic.Identity;

public class GrupoId extends Identity {
    public GrupoId(){}

    public GrupoId(String id){
        super(id);
    }
    public static GrupoId of(String id){
        return new GrupoId(id);
    }
}
