package co.com.sofka.personalizedtraining.domain.entrenador.values;

import co.com.sofka.domain.generic.Identity;

public class FuncionId extends Identity {
    public FuncionId(){}

    public FuncionId(String id){
        super(id);
    }
    public static FuncionId of(String id){
        return new FuncionId(id);
    }
}
