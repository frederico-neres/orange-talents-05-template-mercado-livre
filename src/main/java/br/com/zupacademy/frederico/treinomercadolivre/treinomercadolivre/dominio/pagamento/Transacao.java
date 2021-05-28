package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.pagamento;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.compra.Compra;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String idTransacao;
    @NotNull
    @Enumerated
    private StatusTransacao status;
    @ManyToOne
    private Compra compra;

    @Deprecated
    public Transacao() {
    }

    public Transacao(@NotBlank String idTransacao, @NotBlank StatusTransacao statusTransacao, Compra compra) {
        this.idTransacao = idTransacao;
        this.status = statusTransacao;
        this.compra = compra;
    }

    public boolean isStatusSucesso() {
        return this.status.equals(StatusTransacao.SUCESSO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(idTransacao, transacao.idTransacao) && status == transacao.status && Objects.equals(compra, transacao.compra);
    }


}
