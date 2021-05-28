package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.StatusTransacao;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.Transacao;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PaypalRequest implements GatewayRequest{

    @NotBlank
    private String idTransacao;
    @Min(0)
    @Max(1)
    private int status;

    public PaypalRequest(@NotBlank String idTransacao, @Min(0) @Max(1) int status) {
        this.idTransacao = idTransacao;
        this.status = status;
    }

    public Transacao toTransacao(Compra compra) {
        StatusTransacao statusTransacao = status == 1? StatusTransacao.SUCESSO:
                StatusTransacao.ERRO;

        return new Transacao(idTransacao, statusTransacao, compra);
    }

}
