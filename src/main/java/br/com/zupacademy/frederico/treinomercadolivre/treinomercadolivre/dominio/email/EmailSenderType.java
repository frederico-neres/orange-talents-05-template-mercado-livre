package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email;

public enum EmailSenderType {
    FAKE(new EmailSenderFake());

    EmailSender emailSender;

    EmailSenderType(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public EmailSender getEmailSender() {
        return emailSender;
    }
}
