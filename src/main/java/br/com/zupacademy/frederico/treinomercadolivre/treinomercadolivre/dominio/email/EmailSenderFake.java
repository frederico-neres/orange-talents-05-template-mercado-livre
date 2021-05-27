package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email;

public class EmailSenderFake implements  EmailSender{

    @Override
    public void send(EmailPayload emailPayload) {
        System.out.println("------------------------------");
        System.out.println("Assunto: " + emailPayload.getSubject());
        System.out.println("------------------------------");
        System.out.println("Para: " + emailPayload.getTo());
        System.out.println("------------------------------");
        System.out.println(emailPayload.getHtml());
        System.out.println("------------------------------");
        System.out.println("Enviado por: " + emailPayload.getFrom());
        System.out.println("------------------------------");
    }
}
