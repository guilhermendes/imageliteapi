package io.github.guilhermendes.imageliteapi.infra.respository;

import io.github.guilhermendes.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
