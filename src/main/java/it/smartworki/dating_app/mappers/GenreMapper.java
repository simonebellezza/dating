package it.smartworki.dating_app.mappers;

import it.smartworki.dating_app.dtos.GenreDTO;
import it.smartworki.dating_app.entities.Genre;

import java.util.stream.Collectors;

public class GenreMapper {

    public static GenreDTO toDTO(Genre genre) {
        if (genre == null) {
            return null;
        }
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setType(genre.getType());
        return genreDTO;
    }

//    public static Genre toEntity(GenreDTO genreDTO) {
//        if (genreDTO == null) {
//            return null;
//        }
//        Genre genre = new Genre();
//        genre.setId(genreDTO.getId());
//        genre.setType(genreDTO.getType());
//        return genre;
//    }
}
