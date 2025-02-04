package edu.ifrn.tsi.sgpt.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import edu.ifrn.tsi.sgpt.domain.usuario.Usuario;
import edu.ifrn.tsi.sgpt.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private ServiceToken serviceToken;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    var tokenJWT = recuperarToken(request);
    if (tokenJWT != null) {
      String email = serviceToken.getSubject(tokenJWT);
      Usuario usuario = usuarioRepository.findByEmail(email);
      if (usuario != null) {
        var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    filterChain.doFilter(request, response); // Next do nodejs
  }

  public String recuperarToken(HttpServletRequest request) {
    var tokenJWT = request.getHeader("Authorization");
    if (tokenJWT != null && tokenJWT.startsWith("Bearer ")) {
      return tokenJWT.replace("Bearer ", "");
    }
    return null;
  }

}
