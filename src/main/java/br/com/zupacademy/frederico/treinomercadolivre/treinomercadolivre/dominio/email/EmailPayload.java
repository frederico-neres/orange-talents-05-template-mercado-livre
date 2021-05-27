package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.email;

public class EmailPayload {

    private String subject;
    private String html;
    private String to;
    private String from;

    public EmailPayload(String subject, String html, String to, String from) {
        this.subject = subject;
        this.html = html;
        this.to = to;
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public String getHtml() {
        return html;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

}
