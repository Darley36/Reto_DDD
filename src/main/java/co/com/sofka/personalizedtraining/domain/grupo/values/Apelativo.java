package co.com.sofka.personalizedtraining.domain.grupo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Apelativo implements ValueObject<String> {
    private final String value;

    public Apelativo(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("el apelativo no puede estar vacia");
        }

        if(this.value.length() > 100){
            throw new IllegalArgumentException("debe ser menor a 100 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apelativo apelativo = (Apelativo) o;
        return Objects.equals(value, apelativo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
