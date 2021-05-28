package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.adapter;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email.EmailManager;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email.EmailPayload;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email.EmailSenderType;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.ProcessAfterPagamento;
import org.springframework.stereotype.Component;

@Component
public class ObservableAdapterEmailManager implements ProcessAfterPagamento {
    @Override
    public void executa(Compra compra) {
        String html = "Pagamento concluído com sucesso -> PRODUTO: " + compra.getProdutoNome()
                + " | QUANTIDADE: " + compra.getQuantidade()
                + " | TIPO DE PAGAMENTO: " + compra.getGateway();

        EmailPayload emailPayload = new EmailPayload("Pagamento efetuado",
                html, compra.getProdutoUsuarioEmail(),
                "sistema@email.com");

        EmailManager.send(EmailSenderType.FAKE, emailPayload);
    }
}
