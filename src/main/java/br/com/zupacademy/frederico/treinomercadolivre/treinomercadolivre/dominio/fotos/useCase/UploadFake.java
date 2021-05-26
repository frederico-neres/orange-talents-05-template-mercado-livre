package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.useCase;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.Foto;
import org.springframework.web.multipart.MultipartFile;


public class UploadFake implements UploadMultipartFile{
    @Override
    public Foto upload(MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String link = "https://www.fake-image/" + fileName;

        return new Foto(link, fileName);
    }
}
