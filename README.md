# Gerenciador de Tarefas

Projeto desenvolvido para a atividade da faculdade utilizando Java e Spring Boot.

O sistema permite cadastrar, listar, atualizar e excluir tarefas pessoais.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Maven
- Postman

## Endpoints

| Método | Endereço        | Função           |
|--------|-----------------|------------------|
| GET    | `/tarefas`      | Listar tarefas   |
| GET    | `/tarefas/{id}` | Buscar tarefa    |
| POST   | `/tarefas`      | Cadastrar tarefa |
| PUT    | `/tarefas/{id}` | Atualizar tarefa |
| DELETE | `/tarefas/{id}` | Excluir tarefa   |

## Exemplo de cadastro

```json
{
  "titulo": "Estudar Java",
  "descricao": "Atividade da faculdade",
  "concluida": false
}
```

## Testes

Todos os métodos foram testados no Postman e estão funcionando corretamente.

O projeto utiliza armazenamento em memória, portanto as tarefas são perdidas quando a aplicação é reiniciada.