package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.api;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.Foto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.dto.FotosRequest;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.useCase.UploadType;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/upload/fotos/produtos")
public class UploadFotosProduto {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping("{id}")
    @Transactional
    public ResponseEntity<?> uploadFotos(@PathVariable Long id, @Valid FotosRequest fotosRequest,
                                         @AuthenticationPrincipal Usuario usuarioLogado){
        Produto produto = entityManager.find(Produto.class, id);
        if(!produto.pertenceUsuario(usuarioLogado)) {
           return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        List<MultipartFile> multipartFile = fotosRequest.getFotos();
        List<Foto> fotos = uploadMultipartFile(multipartFile);

        produto.adicionaFotos(fotos);
        entityManager.merge(produto);

        return ResponseEntity.ok(null);
    }

    private List<Foto> uploadMultipartFile(List<MultipartFile> multipartFile) {
        return multipartFile.stream()
                .map(UploadType.FAKE.getUploadManager()::upload).collect(Collectors.toList());
    }

}
