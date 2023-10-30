package org.example.domain;

public interface Validator<T> {

    void validate(T entity) throws ValidationException;
}
