package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.api;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.dto.LoginRequest;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.dto.TokenResponse;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.security.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager,TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken dadosLogin = loginRequest.converter();

        try {
            Authentication authenticate = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authenticate);

            return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
        }catch (AuthenticationException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }


}
