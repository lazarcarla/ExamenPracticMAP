package org.example.domain;

import java.awt.*;

public class TablouValidator implements Validator<Tablou>{
    @Override
    public void validate(Tablou entity) throws ValidationException {
        if(entity.getTitlu() == null || entity.getPictor() == null)
            throw  new ValidationException("Titlul sau pictorul nu pot fii nule!");

        if(entity.getTematica() != "natura" || entity.getTematica() != "abstract"
                || entity.getTematica() != "orase" || entity.getTematica() != "portret" )
            throw new ValidationException("Tematica tabloului poate fii doar natura,abstract,orase sau portret!");

    }
}
