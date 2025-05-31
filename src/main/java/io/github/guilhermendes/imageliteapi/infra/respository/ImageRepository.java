package io.github.guilhermendes.imageliteapi.infra.respository;

import io.github.guilhermendes.imageliteapi.domain.entity.Image;
import io.github.guilhermendes.imageliteapi.domain.enums.ImageExtension;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

     default List<Image> findByExtensionAndNAmeOrTagsLike(ImageExtension extension, String query){
         Specification<Image> conjunction = (root, q, criteriaBuilder) -> criteriaBuilder.conjunction();
         Specification<Image> spec = Specification.where( conjunction );

         if(extension != null){
             Specification<Image> extensionEqual = (root, query1, criteriaBuilderb) -> criteriaBuilderb.equal(root.get("extension"), extension);
             spec = spec.and(extensionEqual);
         }

         if(StringUtils.hasText(query)){
     Specification<Image> nameLike = (root, query1, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + query.toLowerCase() + "%");
             Specification<Image> tagsLike  = (root, query1, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("tags")), "%" + query.toLowerCase() + "%");

             Specification<Image> nameOrTagsLike = Specification.anyOf(nameLike, tagsLike);
             spec = spec.and(nameOrTagsLike);
         }

         return findAll();
     }

}
