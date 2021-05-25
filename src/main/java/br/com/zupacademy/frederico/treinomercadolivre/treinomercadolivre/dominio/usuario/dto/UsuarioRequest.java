package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation.UniqueValue;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.SenhaLimpa;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest {
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    @UniqueValue(fieldName = "login",
            domainClass = Usuario.class,
            message = "Já existe um(a) usuário(a) cadastrado(a) com esse e-mail")
    private String login;
    @NotBlank
    @Size(min = 6)
    private String senha;


    public UsuarioRequest(@NotBlank String nome, @NotBlank @Email String login, @NotBlank @Size(min = 6) String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario toModel() {
        return new Usuario(nome, login, new SenhaLimpa(senha));
    }
}
