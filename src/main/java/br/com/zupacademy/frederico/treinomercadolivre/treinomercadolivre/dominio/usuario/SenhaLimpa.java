package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaLimpa {
    private String senha;

    public SenhaLimpa(String senha) {
        this.senha = senha;
    }

    public String encode() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }
}
