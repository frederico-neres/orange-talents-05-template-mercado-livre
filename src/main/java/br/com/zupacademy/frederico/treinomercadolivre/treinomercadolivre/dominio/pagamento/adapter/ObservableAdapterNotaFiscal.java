package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.adapter;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.ProcessAfterPagamento;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.fakeClient.openFeign.NotaFiscalEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObservableAdapterNotaFiscal implements ProcessAfterPagamento {

    @Autowired
    NotaFiscalEndpoint notaFiscalEndpoint;

    @Override
    public void executa(Compra compra) {
        notaFiscalEndpoint.geraNota(compra.getId(), compra.getIdUsuario());
    }
}
