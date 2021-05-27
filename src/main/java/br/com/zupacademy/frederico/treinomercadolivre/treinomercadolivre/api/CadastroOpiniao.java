package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.api;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.opiniao.Opiniao;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.opiniao.dto.OpiniaoRequest;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/opinioes")
public class CadastroOpiniao {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvarOpiniao(@RequestBody @Valid OpiniaoRequest opiniaoRequest, @AuthenticationPrincipal Usuario usuarioLogado) {
        Opiniao opiniao = opiniaoRequest.toModel(entityManager, usuarioLogado);
        entityManager.persist(opiniao);

        return ResponseEntity.ok(null);
    }
}
