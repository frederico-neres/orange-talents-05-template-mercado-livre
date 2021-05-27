package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.detalhes.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Caracteristica;

public class DetalhesCaracteristicaProdutoResponse {
    private String nome;
    private String descricao;

    public DetalhesCaracteristicaProdutoResponse(Caracteristica caracteristica) {
        this.nome = caracteristica.getNome();
        this.descricao = caracteristica.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
