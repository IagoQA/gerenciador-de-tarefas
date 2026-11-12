
package br.com.iago.gerenciador_tarefas.controller;

import br.com.iago.gerenciador_tarefas.model.Tarefa;
import br.com.iago.gerenciador_tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {

        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {

        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.buscarPorId(id);

        if (tarefa == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "Tarefa não encontrada", "status", 404));
        }

        return ResponseEntity.ok(tarefa);
    }

    @PostMapping
    public ResponseEntity<Tarefa> adicionar(@Valid @RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.adicionar(tarefa);

        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Tarefa tarefa) {

        Tarefa atualizada = tarefaService.atualizar(id, tarefa);

        if (atualizada == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "Tarefa não encontrada", "status", 404));
        }

        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {

        boolean excluida = tarefaService.excluir(id);

        if (!excluida) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", "Tarefa não encontrada", "status", 404));
        }

        return ResponseEntity.noContent().build();
    }
}
