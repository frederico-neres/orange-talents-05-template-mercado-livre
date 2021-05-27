package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.categoria.Categoria;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoRequest {
    @NotBlank
    private String nome;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotNull
    @Positive
    private int quantidadeDisponivel;
    @Size(min = 3)
    private List<CaracteristicaRequest> caracteristicas;
    @NotBlank
    @Length(max = 1000)
    private  String descricao;
    @NotNull
    private Long idCategoria;

    public ProdutoRequest(@NotBlank String nome, @NotNull @Positive BigDecimal valor,
                          @NotNull @Positive int quantidadeDisponivel,
                          @Size(min = 3) @Valid List<CaracteristicaRequest> caracteristicas,
                          @NotBlank @Length(max = 1000) String descricao,@NotNull Long idCategoria) {
        this.nome = nome;
        this.valor = valor;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.caracteristicas = caracteristicas;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
    }

    public Produto toModel(EntityManager entityManager, Usuario usuarioLogado) {
        Categoria categoria = entityManager.find(Categoria.class, idCategoria);
        return new Produto(nome, valor, quantidadeDisponivel, caracteristicas,
                descricao, categoria, usuarioLogado);
    }
}
