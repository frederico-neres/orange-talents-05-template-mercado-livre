package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.detalhes.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.opiniao.Opiniao;

public class OpinioesProdutoResponse {

    private int nota;
    private String titulo;
    private String descricao;

    public OpinioesProdutoResponse(Opiniao opiniao) {
        this.nota = opiniao.getNota();
        this.titulo = opiniao.getTitulo();
        this.descricao = opiniao.getDescricao();

    }

    public int getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

}
