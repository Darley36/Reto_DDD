package co.com.sofka.personalizedtraining.domain.grupo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;
import co.com.sofka.personalizedtraining.domain.grupo.values.GrupoId;

import java.util.Set;

public class Grupo extends AggregateEvent<GrupoId> {
    protected Apelativo apelativo;
    protected EquipoEntrenamiento equipoEntrenamiento;
    protected Set<Reto> retos;
    protected Set<Miembro> miembros;

    public Grupo(GrupoId entityId, Apelativo apelativo) {
        super(entityId);
    }
}
