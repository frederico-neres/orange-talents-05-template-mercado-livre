package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos;

public class Foto {
    private String link;
    private String nome;

    public Foto(String link, String nome) {
        this.link = link;
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public String getNome() {
        return nome;
    }
}
