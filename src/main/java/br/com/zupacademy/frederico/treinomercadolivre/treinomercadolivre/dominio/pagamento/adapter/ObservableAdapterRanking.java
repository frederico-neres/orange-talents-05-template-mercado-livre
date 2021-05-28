package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.adapter;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.ProcessAfterPagamento;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.fakeClient.openFeign.RankingEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObservableAdapterRanking implements ProcessAfterPagamento {

    @Autowired
    RankingEndpoint rankingEndpoint;

    @Override
    public void executa(Compra compra) {
        rankingEndpoint.rankear(compra.getId(), compra.getIdProdutoUsuario());
    }
}
