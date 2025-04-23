package it.smartworki.dating_app.mappers;

import it.smartworki.dating_app.converters.DateConverter;
import it.smartworki.dating_app.dtos.*;
import it.smartworki.dating_app.entities.Genre;
import it.smartworki.dating_app.entities.User;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserResponseDTO toDTO(User user) {
        if (user == null)
            return null;

        UserResponseDTO userDTO = new UserResponseDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setBio(user.getBio());
        userDTO.setAccountType(user.getAccountType());
        userDTO.setRegistrationDate(user.getRegistrationDate());
        userDTO.setGenres(user.getGenres().stream()
                .map(Genre::getType)
                .collect(Collectors.toSet()));
        userDTO.setAge(DateConverter.calculateAge(user.getBirthday()));
        userDTO.setPreferences(PreferenceMapper.toDTO(user.getPreference()));

        return userDTO;
    }

    public static User toEntity(UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO == null)
            return null;

        User user = new User();

        user.setName(userRegisterDTO.getName());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(userRegisterDTO.getPassword());
        user.setBirthday(userRegisterDTO.getBirthday());
        user.setBio(userRegisterDTO.getBio());
        user.setRegistrationDate(LocalDate.now());
        return user;
    }

    public static UserResponseMinimalDTO toMinimalDTO(User user) {
        if (user == null)
            return null;

        UserResponseMinimalDTO dto = new UserResponseMinimalDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        // dto.setImagePath(user.getImagePath());
        dto.setGenres(user.getGenres().stream().map(Object::toString).collect(Collectors.toSet()));
        dto.setAge(DateConverter.calculateAge(user.getBirthday()));

        return dto;
    }
}
