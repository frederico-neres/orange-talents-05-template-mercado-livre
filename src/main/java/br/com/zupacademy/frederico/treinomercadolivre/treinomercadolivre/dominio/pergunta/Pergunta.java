package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pergunta;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Usuario usuario;

    public Pergunta(@NotBlank String titulo, Produto produto, Usuario usuarioLogado) {
        this.titulo = titulo;
        this.produto = produto;
        usuario = usuarioLogado;
    }

    public String getOwnerProductEmail() {
        return this.produto.getUsuarioEmail();
    }

    public String getTitulo() {
        return titulo;
    }
}

