package co.com.sofka.personalizedtraining.domain.entrenador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Experiencia implements ValueObject<String> {
    private final String value;

    public Experiencia(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("la experiencia no puede estar vacia");
        }

        if(this.value.length() < 10){
            throw new IllegalArgumentException("debe ser mayor a 10 caracteres");
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
        Experiencia that = (Experiencia) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
