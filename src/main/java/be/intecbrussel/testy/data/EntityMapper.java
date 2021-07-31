package be.intecbrussel.testy.data;

import java.util.Collection;

public interface EntityMapper<E, D> {

    E toEntity (D d);

    Collection<E> toEntities(Collection<D> ds);
}
