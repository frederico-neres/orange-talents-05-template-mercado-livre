package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.fakeClient.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @PostMapping
    public void rankear(Long idCompra, Long idVendedor) {
        System.out.println("Elevando o nível de ranking...");
        System.out.println("Ranking atualizado");

    }
}