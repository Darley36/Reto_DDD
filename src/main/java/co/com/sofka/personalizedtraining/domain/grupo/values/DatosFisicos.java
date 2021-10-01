package co.com.sofka.personalizedtraining.domain.grupo.values;

import co.com.sofka.domain.generic.ValueObject;

public class DatosFisicos implements ValueObject<Double> {
    private final Double value;

    public DatosFisicos(Double value) {
        this.value = value;
        if (this.value == null) {
            throw new IllegalArgumentException("la serie no puede estar vacia");
        }
    }

    public Double value() {
        return value;
    }
}
