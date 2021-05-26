package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.categoria.Categoria;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.Foto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.fotos.FotoProduto;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.produto.dto.CaracteristicaRequest;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotNull
    @Positive
    private int quantidadeDisponivel;
    @Size(min = 3)
    @OneToMany(mappedBy = "produto", cascade=CascadeType.PERSIST)
    private List<Caracteristica> caracteristicas;
    @NotBlank
    @Length(max = 1000)
    private String descrição;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "produto", cascade=CascadeType.MERGE)
    private List<FotoProduto> fotos;


    @Deprecated
    public Produto() {
    }

    public Produto(String nome, BigDecimal valor, int quantidadeDisponivel,
                   List<CaracteristicaRequest> caracteristicas, String descrição,
                   Categoria categoria, Usuario usuarioLogado) {

        this.nome = nome;
        this.valor = valor;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.caracteristicas = caracteristicas.stream().map(this::pegarEntidadeCaracteristica)
                .collect(Collectors.toList());
        this.descrição = descrição;
        this.categoria = categoria;
        this.usuario = usuarioLogado;
    }

    private Caracteristica pegarEntidadeCaracteristica(CaracteristicaRequest caracteristica) {
        return caracteristica.toModel(this);
    }

    public boolean pertenceUsuario(Usuario usuarioLogado) {
        return this.usuario.equals(usuarioLogado);
    }

    public void adicionaFotos(List<Foto> fotos) {
        this.fotos = fotos.stream()
                .map(foto -> new FotoProduto(foto.getLink(), foto.getNome(),this))
                .collect(Collectors.toList());
    }
}
