
package br.com.iago.gerenciador_tarefas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
                .stream()
                .findFirst()
                .map(erro -> erro.getDefaultMessage())
                .orElse("Dados inválidos. Verifique os campos enviados.");

        resposta.put("erro", "Erro de validação");
        resposta.put("mensagem", mensagem);
        resposta.put("status", 400);

        return ResponseEntity.badRequest().body(resposta);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> tratarJsonInvalido(
            HttpMessageNotReadableException ex) {

        Map<String, Object> resposta = new HashMap<>();

        resposta.put("erro", "Requisição inválida");
        resposta.put("mensagem", "Verifique se o JSON enviado está correto.");
        resposta.put("status", 400);

        return ResponseEntity.badRequest().body(resposta);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> tratarErro(Exception ex) {

        Map<String, Object> resposta = new HashMap<>();

        resposta.put("erro", "Erro interno");
        resposta.put("mensagem", "Ocorreu um erro inesperado. Tente novamente.");
        resposta.put("status", 500);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(resposta);
    }
}
