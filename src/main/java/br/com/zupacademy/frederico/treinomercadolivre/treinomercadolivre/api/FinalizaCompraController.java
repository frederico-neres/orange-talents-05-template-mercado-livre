package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.api;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.CompraStatus;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.dto.CompraFinalizadaResponse;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.ObservablePagamento;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.dto.GatewayRequest;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.dto.PagseguroRequest;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento.dto.PaypalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping
public class FinalizaCompraController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ObservablePagamento observablePagamento;

    @PostMapping("/paypal/{id}")
    @Transactional
    public ResponseEntity<?> FinalizaPaypal(@PathVariable long id, @Valid PaypalRequest paypalRequest) {
        return processaPagamento(id, paypalRequest);
    }

    @PostMapping("/pagseguro/{id}")
    @Transactional
    public ResponseEntity<?> FinalizaPagseguro(@PathVariable long id, @Valid PagseguroRequest pagseguroRequest) {
        return processaPagamento(id, pagseguroRequest);
    }

    private ResponseEntity<?> processaPagamento(Long id, GatewayRequest request) {
        Compra compra = entityManager.find(Compra.class, id);
        boolean isFinalizado = compra.finalizaPagamento(request);

        if(!isFinalizado) {
            return ResponseEntity.badRequest().build();
        }

        observablePagamento.executa(compra);
        CompraStatus compraStatus = compra.statusParaFinalizada();

        entityManager.merge(compra);
        return ResponseEntity.ok(new CompraFinalizadaResponse(compraStatus));
    }
}
