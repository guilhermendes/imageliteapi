package io.github.guilhermendes.imageliteapi.application.images;

import io.github.guilhermendes.imageliteapi.domain.entity.Image;
import io.github.guilhermendes.imageliteapi.domain.service.ImageService;
import io.github.guilhermendes.imageliteapi.infra.respository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;

    @Override
    @Transactional
    public Image save(Image image) {
        return repository.save(image);
    }

    @Override
    public Optional<Image> getById(String id) {
        return repository.findById(id);
    }
}
