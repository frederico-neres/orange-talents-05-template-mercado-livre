package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.fakeClient.openFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "nota-fiscal", url = "localhost:8080/nota-fiscal")
public interface NotaFiscalEndpoint {

    @RequestMapping(method = RequestMethod.POST, value = "")

    void geraNota(@SpringQueryMap @ModelAttribute Long idCompra,
                  @SpringQueryMap @ModelAttribute Long idComprador);
}

