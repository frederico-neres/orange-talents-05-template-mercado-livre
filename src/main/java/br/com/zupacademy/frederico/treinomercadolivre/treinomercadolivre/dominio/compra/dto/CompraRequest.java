package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation.AlreadyExists;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.GatewayType;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CompraRequest {

    @NotNull
    @Enumerated(EnumType.STRING)
    private GatewayType gateway;
    @NotNull
    @AlreadyExists(fieldName = "id", domainClass = Produto.class)
    private long idProduto;
    @NotNull
    @Positive
    private int quantidade;

    public CompraRequest(@NotNull long idProduto, @NotNull @Positive int quantidade,
                         @NotNull GatewayType gateway) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.gateway = gateway;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Compra toModel(Produto produto, Usuario usuarioLogado) {
        return new Compra(gateway, produto, quantidade, usuarioLogado);
    }
}
