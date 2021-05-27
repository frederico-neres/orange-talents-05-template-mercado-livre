package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.api;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.opiniao.Opiniao;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.opiniao.repository.OpiniaoRepository;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.Produto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.detalhes.dto.DetalhesOpinioesProdutoResponse;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.detalhes.dto.DetalhesProdutoResponse;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.detalhes.dto.OpinioesProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/detalhes")
public class detalheController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    OpiniaoRepository opiniaoRepository;

    @GetMapping("/{idProduto}")
    public ResponseEntity<DetalhesProdutoResponse> listaDetalhesProduto(@PathVariable Long idProduto) {

        Produto produto = entityManager.find(Produto.class, idProduto);
        return ResponseEntity.ok(new DetalhesProdutoResponse(produto));
    }

    @GetMapping("/{idProduto}/opinioes")
    public ResponseEntity<?> listaOpinioesProduto(@PathVariable Long idProduto,  Pageable pageable) {
        Page<Opiniao> all = opiniaoRepository.findAll(pageable);
        List<OpinioesProdutoResponse> opinioesResponse = all.stream().
                map(OpinioesProdutoResponse::new).collect(Collectors.toList());

        long count = opiniaoRepository.count();
        Double average = opiniaoRepository.averageOfNota(idProduto);

        return  ResponseEntity.ok(new DetalhesOpinioesProdutoResponse(opinioesResponse, average, count, all.isLast(),
                all.getTotalPages(), all.getTotalElements(), all.getSize(), all.getNumber(), all.isFirst()));
    }
}
