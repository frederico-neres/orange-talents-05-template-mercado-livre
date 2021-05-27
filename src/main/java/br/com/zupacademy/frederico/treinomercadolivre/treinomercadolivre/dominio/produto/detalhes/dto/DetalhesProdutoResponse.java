package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.detalhes.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesProdutoResponse {
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private List<DetalhesCaracteristicaProdutoResponse> caracteristicas;
    private List<DetalhesPerguntaProdutoResponse> perguntas;
    private List<DetalhesFotoProdutoProdutoResponse> fotos;


    public DetalhesProdutoResponse(Produto produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.caracteristicas = produto.getCaracteristicas().stream()
                .map(DetalhesCaracteristicaProdutoResponse::new)
                .collect(Collectors.toList());
        this.perguntas = produto.getPerguntas().stream()
                .map(DetalhesPerguntaProdutoResponse::new)
                .collect(Collectors.toList());
        this.fotos = produto.getFotos().stream()
                .map(DetalhesFotoProdutoProdutoResponse::new)
                .collect(Collectors.toList());

    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public List<DetalhesCaracteristicaProdutoResponse> getCaracteristicas() {
        return caracteristicas;
    }

    public List<DetalhesPerguntaProdutoResponse> getPerguntas() {
        return perguntas;
    }

    public List<DetalhesFotoProdutoProdutoResponse> getFotos() {
        return fotos;
    }
}
