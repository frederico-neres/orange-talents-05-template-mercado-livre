package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.PagseguroStatus;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.Transacao;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PagseguroRequest implements GatewayRequest{

    @NotBlank
    private String idTransacao;
    @NotNull
    @Enumerated
    private PagseguroStatus status;

    public PagseguroRequest(@NotBlank String idTransacao, @NotNull PagseguroStatus status) {
        this.idTransacao = idTransacao;
        this.status = status;
    }

    public Transacao toTransacao(Compra compra) {
        return new Transacao(idTransacao, status.parse(), compra);
    }

}
