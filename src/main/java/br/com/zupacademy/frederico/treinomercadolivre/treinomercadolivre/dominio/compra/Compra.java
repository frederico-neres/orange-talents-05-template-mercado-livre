package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.GatewayType;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Enumerated()
    private GatewayType gateway;
    @NotNull
    @Enumerated()
    private CompraStatus status;
    @ManyToOne
    private Produto produto;
    @NotNull
    @Positive
    private int quantidade;
    @ManyToOne
    private Usuario usuario;
    private BigDecimal valorMomento;

    public Compra( @NotNull GatewayType gateway, Produto produto, @NotNull @Positive int quantidade, Usuario usuario) {
        this.gateway = gateway;
        this.produto = produto;
        this.valorMomento = produto.getValor();
        this.quantidade = quantidade;
        this.usuario = usuario;
        this.status = CompraStatus.INICIADA;
    }

    public long getId() {
        return id;
    }

    public GatewayType getGateway() {
        return gateway;
    }
}
