package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pergunta.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation.AlreadyExists;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pergunta.Pergunta;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PerguntaResquest {

    @NotBlank
    private String titulo;
    @NotNull
    @AlreadyExists(fieldName = "id", domainClass = Produto.class)
    private Long idProduto;

    public PerguntaResquest(@NotBlank String titulo, @NotNull Long idProduto) {
        this.titulo = titulo;
        this.idProduto = idProduto;
    }

    public Pergunta toModel(EntityManager entityManager, Usuario usuarioLogado) {
        Produto produto = entityManager.find(Produto.class, idProduto);

        return new Pergunta(titulo, produto, usuarioLogado);
    }
}
