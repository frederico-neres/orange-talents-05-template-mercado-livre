package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.detalhes.dto;

import java.util.List;

public class DetalhesOpinioesProdutoResponse {
    private List<OpinioesProdutoResponse> opinioes;
    private Double media;
    private Long total;
    private Boolean last;
    private int totalPages;
    private Long totalElements;
    private int size;
    private int number;
    private Boolean first;

    public DetalhesOpinioesProdutoResponse(List<OpinioesProdutoResponse> opinioes, Double media,
                                           Long total, Boolean last, int totalPages, Long totalElements,
                                           int size, int number, Boolean first) {
        this.opinioes = opinioes;
        this.media = media;
        this.total = total;
        this.last = last;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.size = size;
        this.number = number;
        this.first = first;
    }

    public List<OpinioesProdutoResponse> getOpinioes() {
        return opinioes;
    }

    public Double getMedia() {
        return media;
    }

    public Long getTotal() {
        return total;
    }

    public Boolean getLast() {
        return last;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public int getSize() {
        return size;
    }

    public int getNumber() {
        return number;
    }

    public Boolean getFirst() {
        return first;
    }
}
