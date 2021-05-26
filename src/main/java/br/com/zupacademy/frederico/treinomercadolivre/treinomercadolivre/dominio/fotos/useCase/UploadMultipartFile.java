package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.useCase;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.Foto;
import org.springframework.web.multipart.MultipartFile;

public interface UploadMultipartFile {
    Foto upload(MultipartFile multipartFile);
}
