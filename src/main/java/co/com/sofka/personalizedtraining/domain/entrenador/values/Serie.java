package co.com.sofka.personalizedtraining.domain.entrenador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Serie implements ValueObject<Integer> {
    private final Integer value;

    public Serie(Integer value) {
        this.value = value;
        if (this.value == null) {
            throw new IllegalArgumentException("la serie no puede estar vacia");
        }
    }

    public Integer value() {
        return value;
    }
}
