package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.fakeClient.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nota-fiscal")
public class NotaFiscalController {

    @PostMapping
    public void geraNota(Long idCompra, Long idComprador) {

        System.out.println("Gerando a nota fiscal...");
        System.out.println("Nota fiscal gerada!");
    }
}
