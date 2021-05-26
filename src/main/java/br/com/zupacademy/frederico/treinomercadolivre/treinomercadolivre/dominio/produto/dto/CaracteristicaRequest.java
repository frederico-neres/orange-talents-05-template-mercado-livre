package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Caracteristica;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;

import javax.validation.constraints.NotBlank;

public class CaracteristicaRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public CaracteristicaRequest(@NotBlank String nome, @NotBlank String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Caracteristica toModel(Produto produto) {
        return new Caracteristica(nome, descricao, produto);
    }
}
