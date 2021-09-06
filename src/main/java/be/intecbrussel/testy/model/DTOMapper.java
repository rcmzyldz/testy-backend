package be.intecbrussel.testy.model;

public interface DTOMapper<C, U, S, R> {

    C toCreate();

    U toUpdate();

    S toSearch();

    R toResponse();
}
