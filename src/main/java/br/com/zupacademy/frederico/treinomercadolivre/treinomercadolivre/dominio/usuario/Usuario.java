package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.OffsetDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String login;
    @NotBlank
    @Size(min = 6)
    private String senha;
    @NotNull
    private OffsetDateTime instante = OffsetDateTime.now();

    public Usuario(String nome, String login, SenhaLimpa senha) {

        this.nome = nome;
        this.login = login;
        this.senha = senha.encode();
    }
}
