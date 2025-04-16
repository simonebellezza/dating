package it.smartworki.dating_app.mappers;

import it.smartworki.dating_app.converters.DateConverter;
import it.smartworki.dating_app.dtos.UserPreferenceResponseDTO;
import it.smartworki.dating_app.dtos.UserRequestDTO;
import it.smartworki.dating_app.dtos.UserResponseDTO;
import it.smartworki.dating_app.dtos.UserResponseMinimalDTO;
import it.smartworki.dating_app.entities.User;

import java.time.LocalDate;

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
        userDTO.setGenres(user.getGenres().stream().map(g ->
                g.getGenre().getType()).toList());
        userDTO.setAge(DateConverter.calculateAge(user.getBirthday()));
        userDTO.setPreferences(PreferenceMapper.toDTO(user.getPreference()));

        return userDTO;
    }

    public static User toEntity(UserRequestDTO userRequestDTO) {
        if (userRequestDTO == null)
            return null;

        User user = new User();

        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setBirthday(userRequestDTO.getBirthday());
        user.setBio(userRequestDTO.getBio());

        return user;
    }

    public static UserResponseMinimalDTO toMinimalDTO(User user) {
        if (user == null)
            return null;

        UserResponseMinimalDTO dto = new UserResponseMinimalDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        // dto.setImagePath(user.getImagePath());
        dto.setGenres(user.getGenres().stream().map(g ->
                        g.getGenre().getType()).toList());
        dto.setAge(DateConverter.calculateAge(user.getBirthday()));

        return dto;
    }
}
