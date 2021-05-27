package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email;

public interface EmailSender {
    void send(EmailPayload emailPayload);
}
