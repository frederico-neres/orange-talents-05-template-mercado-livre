package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.CompraStatus;

public class CompraFinalizadaResponse {

    private CompraStatus status;

    public CompraFinalizadaResponse(CompraStatus status) {
        this.status = status;
    }

    public CompraStatus getStatus() {
        return status;
    }
}
