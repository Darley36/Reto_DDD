package co.com.sofka.personalizedtraining.domain.grupo.values;

import co.com.sofka.domain.generic.ValueObject;

public class Cantidad implements ValueObject<Integer> {
    private final Integer value;

    public Cantidad(Integer value) {
        this.value = value;
        if (this.value == null) {
            throw new IllegalArgumentException("la serie no puede estar vacia");
        }
    }

    public Integer value() {
        return value;
    }
}
