package it.smartworki.dating_app.security;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthRequest {

	private String name;
	private String email; 
    private String password;
    private LocalDate birthday;
    
   
    
    

}
