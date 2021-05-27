package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.detalhes.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.FotoProduto;

public class DetalhesFotoProdutoProdutoResponse {

    private String link;
    private String nome;

    public DetalhesFotoProdutoProdutoResponse(FotoProduto foto) {
        this.link = foto.getLink();
        this.nome = foto.getNome();
    }

    public String getLink() {
        return link;
    }

    public String getNome() {
        return nome;
    }
}
