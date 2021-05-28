package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.api;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.dto.CompraRequest;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email.EmailManager;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email.EmailPayload;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email.EmailSenderType;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/comprar")
public class CompraController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> finalizarCompra(@RequestBody @Valid CompraRequest compraRequest,
                                             @AuthenticationPrincipal Usuario usuarioLogado,
                                             UriComponentsBuilder uriComponentsBuilder) {

        Produto produto = entityManager.find(Produto.class, compraRequest.getIdProduto());
        Compra compra = compraRequest.toModel(produto, usuarioLogado);

        boolean isAbatido = produto.abaterQuantidadeDisponivel(compraRequest.getQuantidade());
        if (isAbatido) {
            entityManager.persist(compra);

            String html = "Desejo comprar -> PRODUTO: " + produto.getNome()
                    + " | QUANTIDADE: " + compraRequest.getQuantidade()
                    + " | TIPO DE PAGAMENTO: " + compra.getGateway();

            EmailPayload emailPayload = new EmailPayload("Solicitação de compra",
                    html, produto.getUsuarioEmail(),
                    usuarioLogado.getLogin());

            EmailManager.send(EmailSenderType.FAKE, emailPayload);

            String urlRedirect = compra.getGateway()
                    .getUrlRedirect(uriComponentsBuilder, compra.getId());

            return ResponseEntity.status(HttpStatus.FOUND).body(urlRedirect);
        }

        return ResponseEntity.badRequest().build();
    }

}
