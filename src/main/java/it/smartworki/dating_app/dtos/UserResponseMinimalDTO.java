package it.smartworki.dating_app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseMinimalDTO {
    private Long id;
    private String name;
    // private String imagePath;
    private int age;
    private Set<String> genres;
}