package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.api;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email.EmailManager;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email.EmailPayload;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email.EmailSenderType;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pergunta.Pergunta;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pergunta.dto.PerguntaResquest;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/perguntas")
public class CadastroPergunta {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvarPergunta(@RequestBody @Valid PerguntaResquest perguntaResquest,
                                            @AuthenticationPrincipal Usuario usuarioLogado) {
        Pergunta pergunta = perguntaResquest.toModel(entityManager, usuarioLogado);
        entityManager.persist(pergunta);

        EmailPayload emailPayload = new EmailPayload("Alerta de nova pergunta",
                pergunta.getTitulo(), pergunta.getOwnerProductEmail(),
                usuarioLogado.getLogin());

        EmailManager.send(EmailSenderType.FAKE, emailPayload);
        return ResponseEntity.ok(null);
    }
}
