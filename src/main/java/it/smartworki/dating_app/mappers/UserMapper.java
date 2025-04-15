package it.smartworki.dating_app.mappers;

import it.smartworki.dating_app.dtos.UserRequestDTO;
import it.smartworki.dating_app.dtos.UserResponseDTO;
import it.smartworki.dating_app.entities.User;

public class UserMapper {
    public static UserResponseDTO toDTO(User user) {
        if(user == null)
            return null;

        UserResponseDTO userDTO = new UserResponseDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setBio(user.getBio());
        userDTO.setAccountType(user.getAccountType());
        userDTO.setRegistrationDate(user.getRegistrationDate());

        return userDTO;
    }

    public static User toEntity(UserRequestDTO userRequestDTO) {
        if(userRequestDTO == null)
            return null;

        User user = new User();

        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());  // Hash password
        user.setBirthday(userRequestDTO.getBirthday());
        user.setBio(userRequestDTO.getBio());

        return user;
    }
}
