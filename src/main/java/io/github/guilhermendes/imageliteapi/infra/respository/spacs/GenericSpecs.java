package io.github.guilhermendes.imageliteapi.infra.respository.spacs;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecs {
    private GenericSpecs(){}

    public static<T> Specification<T> conjunction(){
        return (root, q, cb) -> cb.conjunction();
    }
}
