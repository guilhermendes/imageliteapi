package io.github.guilhermendes.imageliteapi.aplication.images;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class imageDTO {

    private String url;
    private String name;
    private String extension;
    private Long size;
    private LocalDate uploadDate;



}
