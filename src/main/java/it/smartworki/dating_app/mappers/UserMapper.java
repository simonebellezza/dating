package it.smartworki.dating_app.mappers;

import it.smartworki.dating_app.dtos.UserDTO;
import it.smartworki.dating_app.entities.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        if(user == null)
            return null;

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setBio(user.getBio());
        userDTO.setAccountType(user.getAccountType());
        userDTO.setRegistrationDate(user.getRegistrationDate());

        return userDTO;
    }


}
