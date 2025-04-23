package it.smartworki.dating_app.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	
	private String token;
    private String email;
    private String tokenType = "Bearer";
}
