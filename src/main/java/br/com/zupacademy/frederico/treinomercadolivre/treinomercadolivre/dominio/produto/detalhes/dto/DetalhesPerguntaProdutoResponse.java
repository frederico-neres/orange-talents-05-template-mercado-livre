package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.detalhes.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pergunta.Pergunta;

public class DetalhesPerguntaProdutoResponse {
    private String titulo;

    public DetalhesPerguntaProdutoResponse(Pergunta pergunta) {
        this.titulo = pergunta.getTitulo();
    }

    public String getTitulo() {
        return titulo;
    }
}
