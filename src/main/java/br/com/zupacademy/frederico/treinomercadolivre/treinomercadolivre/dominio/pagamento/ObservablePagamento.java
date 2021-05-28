package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.adapter.ObservableAdapterEmailManager;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.adapter.ObservableAdapterEmailManagerFalha;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.adapter.ObservableAdapterNotaFiscal;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.adapter.ObservableAdapterRanking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObservablePagamento  implements ProcessAfterPagamento {

    private List<ProcessAfterPagamento> processAfterPagamentoListSucesso = new ArrayList<>();
    private List<ProcessAfterPagamento> processAfterPagamentoListFalha = new ArrayList<>();

    public ObservablePagamento(ObservableAdapterNotaFiscal observableAdapterNotaFiscal,
                               ObservableAdapterRanking observableAdapterRanking,
                               ObservableAdapterEmailManager observableAdapterEmailManager,
                               ObservableAdapterEmailManagerFalha observableAdapterEmailManagerFalha) {

        this.processAfterPagamentoListSucesso.add(observableAdapterNotaFiscal);
        this.processAfterPagamentoListSucesso.add(observableAdapterRanking);
        this.processAfterPagamentoListSucesso.add(observableAdapterEmailManager);

        this.processAfterPagamentoListFalha.add(observableAdapterEmailManagerFalha);
    }

    @Override
    public void executa(Compra compra) {
        if(compra.isTransacaoConcluida()) {
            processAfterPagamentoListSucesso.forEach(process -> process.executa(compra));
        }else {
            processAfterPagamentoListFalha.forEach(process-> process.executa(compra));
        }
    }
}
