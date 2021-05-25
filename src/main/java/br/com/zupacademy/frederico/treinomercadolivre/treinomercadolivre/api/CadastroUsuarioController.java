package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.api;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.dto.UsuarioRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class CadastroUsuarioController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity salvarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRequest.toModel();

        entityManager.persist(usuario);
        return  ResponseEntity.ok(null);
    }
}
