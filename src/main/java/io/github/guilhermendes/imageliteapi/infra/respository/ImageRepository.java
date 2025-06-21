package io.github.guilhermendes.imageliteapi.infra.respository;

import io.github.guilhermendes.imageliteapi.domain.entity.Image;
import io.github.guilhermendes.imageliteapi.domain.enums.ImageExtension;
import io.github.guilhermendes.imageliteapi.infra.respository.spacs.GenericSpecs;
import io.github.guilhermendes.imageliteapi.infra.respository.spacs.ImageSpacs;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.guilhermendes.imageliteapi.infra.respository.spacs.GenericSpecs.conjunction;
import static io.github.guilhermendes.imageliteapi.infra.respository.spacs.ImageSpacs.*;
import static org.springframework.data.jpa.domain.Specification.anyOf;
import static org.springframework.data.jpa.domain.Specification.where;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

     default List<Image> findByExtensionAndNAmeOrTagsLike(ImageExtension extension, String query){
         Specification<Image> spec = where(conjunction());

         if(extension != null){
             spec = spec.and(extensionEqual(extension));
         }

         if(StringUtils.hasText(query)){
             spec = spec.and(anyOf(nameLike(query), tagsLike(query)));
         }

         return findAll(spec);
     }

}
