package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class FotosRequest {

    @Size(min = 1)
    @NotNull
    private List<MultipartFile> fotos;

    public void setFotos(List<MultipartFile> fotos) {
        this.fotos = fotos;
    }

    public List<MultipartFile> getFotos() {
        return fotos;
    }
}
