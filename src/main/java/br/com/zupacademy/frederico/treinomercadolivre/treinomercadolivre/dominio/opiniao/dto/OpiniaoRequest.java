package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.opiniao.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation.AlreadyExists;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.opiniao.Opiniao;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;

public class OpiniaoRequest {

    @Min(1)
    @Max(5)
    private int nota;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String descricao;
    @NotNull
    @AlreadyExists(fieldName = "id", domainClass = Produto.class)
    private Long idProduto;


    public OpiniaoRequest(@Min(1) @Max(5) int nota, @NotBlank String titulo,
                          @NotBlank @Size(max = 500) String descricao, @NotNull Long idProduto) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.idProduto = idProduto;
    }

    public Opiniao toModel(EntityManager entityManager, Usuario usuarioLogado) {
        Produto produto = entityManager.find(Produto.class, idProduto);
        return new Opiniao(nota, titulo, descricao, usuarioLogado, produto);
    }
}
