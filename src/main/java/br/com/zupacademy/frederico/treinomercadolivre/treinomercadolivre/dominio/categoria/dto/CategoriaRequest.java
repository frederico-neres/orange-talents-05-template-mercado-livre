package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.categoria.dto;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.annotation.UniqueValue;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.categoria.Categoria;
import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(fieldName = "nome",
            domainClass = Categoria.class,
            message = "Já existe uma categoria cadastrada com esse nome")
    private String nome;
    private Long idCategoriaMae;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdCategoriaMae(Long idCategoriaMae) {
        this.idCategoriaMae = idCategoriaMae;
    }

    public Categoria toModel(EntityManager entityManager) {
        Categoria categoria = new Categoria(nome);

        if(idCategoriaMae != null) {
            Categoria categoriaMae = entityManager.find(Categoria.class, idCategoriaMae);
            categoria.setCategoriaMae(categoriaMae);
        }

        return categoria;
    }
}
