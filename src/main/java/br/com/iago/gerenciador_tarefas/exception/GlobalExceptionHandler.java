
package br.com.iago.gerenciador_tarefas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarValidacao(
            MethodArgumentNotValidException ex) {

        Map<String, Object> resposta = new HashMap<>();

        String mensagem = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        resposta.put("mensagem", mensagem);
        resposta.put("status", 400);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> tratarErro(Exception ex) {

        Map<String, Object> resposta = new HashMap<>();

        resposta.put("mensagem", "Ocorreu um erro interno no servidor");
        resposta.put("status", 500);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(resposta);
    }
}
