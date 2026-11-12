
package br.com.iago.gerenciador_tarefas.service;

import br.com.iago.gerenciador_tarefas.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TarefaService {

    private final List<Tarefa> tarefas = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public List<Tarefa> listarTodas() {
        return tarefas;
    }

    public Tarefa buscarPorId(Long id) {
        return tarefas.stream()
                .filter(tarefa -> tarefa.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Tarefa adicionar(Tarefa tarefa) {
        tarefa.setId(contador.getAndIncrement());
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa atualizar(Long id, Tarefa novaTarefa) {
        Tarefa tarefa = buscarPorId(id);

        if (tarefa == null) {
            return null;
        }

        tarefa.setTitulo(novaTarefa.getTitulo());
        tarefa.setDescricao(novaTarefa.getDescricao());
        tarefa.setConcluida(novaTarefa.isConcluida());

        return tarefa;
    }

    public boolean excluir(Long id) {
        Tarefa tarefa = buscarPorId(id);

        if (tarefa == null) {
            return false;
        }

        tarefas.remove(tarefa);
        return true;
    }
}
