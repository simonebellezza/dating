package it.smartworki.dating_app.mappers;

import it.smartworki.dating_app.dtos.GenreResponseDTO;
import it.smartworki.dating_app.entities.Genre;

public class GenreMapper {

    public static GenreResponseDTO toDTO(Genre genre) {
        if (genre == null) {
            return null;
        }
        GenreResponseDTO genreResponseDTO = new GenreResponseDTO();
        genreResponseDTO.setId(genre.getId());
        genreResponseDTO.setType(genre.getType());
        return genreResponseDTO;
    }

    public static Genre toEntity(GenreResponseDTO genreResponseDTO) {
        if (genreResponseDTO == null) {
            return null;
        }
        Genre genre = new Genre();
        genre.setId(genreResponseDTO.getId());
        genre.setType(genreResponseDTO.getType());
        return genre;
    }
}
