package co.com.sofka.personalizedtraining.domain.entrenador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tema implements ValueObject<String> {
    private final String value;

    public Tema(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El tema no puede estar vacia");
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
        Tema tema = (Tema) o;
        return Objects.equals(value, tema.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
