package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;

public interface ProcessAfterPagamento {

    public void executa(Compra compra);
}
