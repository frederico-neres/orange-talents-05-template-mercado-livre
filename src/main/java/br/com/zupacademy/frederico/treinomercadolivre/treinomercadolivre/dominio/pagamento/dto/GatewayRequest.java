package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.Transacao;

public interface GatewayRequest {
    public Transacao toTransacao(Compra compra);
}
