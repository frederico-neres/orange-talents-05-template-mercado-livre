package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.exceptionHandler.dto;

public class ArgumentError {
    private String field;
    private String mesage;

    public ArgumentError(String field, String mesage) {
        this.field = field;
        this.mesage = mesage;
    }

    public String getField() {
        return field;
    }

    public String getMesage() {
        return mesage;
    }
}
