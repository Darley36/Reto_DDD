package co.com.sofka.personalizedtraining.domain.grupo.values;

import co.com.sofka.domain.generic.Identity;

public class MiembroId extends Identity {
    public MiembroId(){}

    public MiembroId(String id){
        super(id);
    }
    public static MiembroId of(String id){
        return new MiembroId(id);
    }
}
