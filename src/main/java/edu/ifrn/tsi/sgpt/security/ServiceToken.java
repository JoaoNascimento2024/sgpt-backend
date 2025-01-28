package edu.ifrn.tsi.sgpt.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import edu.ifrn.tsi.sgpt.domain.usuario.Usuario;

@Service
public class ServiceToken {

  @Value("${api.security.jwt.secret}")
  private String secret;

  public String gerarToken(Usuario usuario){
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      String token = JWT.create()
          .withIssuer("auth0").withSubject(usuario.getEmail())
          .withClaim("id", usuario.getId().toString())
          .withExpiresAt(gerarDataExpiracao())
          .sign(algorithm);
          return token;
    } catch (JWTCreationException exception){
        // Invalid Signing configuration / Couldn't convert Claims.
    }
    return null;
  }

  public Instant gerarDataExpiracao(){
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }
  
}
