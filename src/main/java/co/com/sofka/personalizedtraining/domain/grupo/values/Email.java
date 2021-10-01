package co.com.sofka.personalizedtraining.domain.grupo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {
    private final String value;

    public Email(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("la mail no puede estar vacia");
        }

        if(this.value.length() < 10){
            throw new IllegalArgumentException("debe ser mayor a 10 caracteres");
        }

        if(!value.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            throw new IllegalArgumentException("el mail no es valido");
        }
    }

    public String value() {
        return value;
    }
}
