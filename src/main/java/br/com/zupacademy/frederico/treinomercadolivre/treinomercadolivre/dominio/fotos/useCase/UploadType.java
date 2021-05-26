package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.useCase;

public enum UploadType {
    FAKE(new UploadFake());

    private UploadMultipartFile uploadManager;

    UploadType(UploadMultipartFile uploadMultipartFile) {
        this.uploadManager = uploadMultipartFile;
    }

    public UploadMultipartFile getUploadManager() {
        return uploadManager;
    }
}
