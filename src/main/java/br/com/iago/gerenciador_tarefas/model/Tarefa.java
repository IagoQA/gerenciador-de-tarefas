
package br.com.iago.gerenciador_tarefas.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Tarefa {

    private Long id;

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres!")
    private String titulo;

    @Size(max = 300, message = "A descrição deve ter no máximo 300 caracteres!")
    private String descricao;

    private boolean concluida;

    public Tarefa() {
    }

    public Tarefa(Long id, String titulo, String descricao, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
