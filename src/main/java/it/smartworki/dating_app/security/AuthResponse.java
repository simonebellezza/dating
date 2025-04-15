package it.smartworki.dating_app.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthResponse {
	
	private String token; // Token JWT generato
    private String email;
    private String tokenType = "Bearer";
}
