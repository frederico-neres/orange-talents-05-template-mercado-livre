package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email;

public class EmailManager {
    public static void send(EmailSenderType emailSenderType, EmailPayload emailPayload) {
        emailSenderType.getEmailSender().send(emailPayload);
    }
}
