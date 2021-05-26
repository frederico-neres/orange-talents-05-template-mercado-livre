package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class FotoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String link;
    @NotBlank
    private String nome;
    @ManyToOne
    private Produto produto;

    @Deprecated
    public FotoProduto() {
    }

    public FotoProduto(String link, String nome, Produto produto) {
        this.link = link;
        this.nome = nome;
        this.produto = produto;
    }
}
