# Gerenciador de Tarefas Pessoais

API REST desenvolvida em Java com Spring Boot para gerenciamento de tarefas pessoais.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Maven
- Spring Web
- Spring Validation
- Springdoc OpenAPI
- Swagger UI

## Organização do projeto

O projeto está organizado em pacotes separados:

- `controller`: recebe e responde às requisições HTTP.
- `service`: contém as operações do sistema.
- `model`: representa os dados das tarefas.
- `exception`: realiza o tratamento de erros e exceções.
- `config`: contém as configurações da documentação OpenAPI.

## Versionamento da API

Foi utilizado o versionamento por URL.

A versão atual é **v1**, com o endereço base:

`http://localhost:8080/api/v1/tarefas`

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/api/v1/tarefas` | Lista todas as tarefas |
| GET | `/api/v1/tarefas/{id}` | Busca uma tarefa pelo ID |
| POST | `/api/v1/tarefas` | Cadastra uma tarefa |
| PUT | `/api/v1/tarefas/{id}` | Atualiza uma tarefa |
| DELETE | `/api/v1/tarefas/{id}` | Exclui uma tarefa |

## Exemplo de requisição POST

```json
{
  "titulo": "Estudar Java",
  "descricao": "Atividade da faculdade",
  "concluida": false
}
```

### Campos

- `titulo`: obrigatório, máximo de 100 caracteres.
- `descricao`: opcional, máximo de 300 caracteres.
- `concluida`: indica se a tarefa foi concluída.

## Códigos de resposta

- `200 OK`: operação realizada com sucesso.
- `201 Created`: tarefa cadastrada.
- `204 No Content`: tarefa excluída.
- `400 Bad Request`: dados inválidos ou JSON incorreto.
- `404 Not Found`: tarefa não encontrada.
- `500 Internal Server Error`: erro interno do servidor.

## Tratamento de erros

A aplicação utiliza `GlobalExceptionHandler` para centralizar o tratamento de exceções.

As respostas apresentam informações como tipo do erro, mensagem e código HTTP, facilitando a identificação de problemas.

## Documentação Swagger / OpenAPI

A documentação é gerada automaticamente utilizando Springdoc OpenAPI.

**Swagger UI:**

`http://localhost:8080/swagger-ui/index.html`

**Especificação OpenAPI em JSON:**

`http://localhost:8080/v3/api-docs`

Pelo Swagger, é possível visualizar os endpoints, consultar os parâmetros e executar requisições para testar a API.

## Arquitetura

O projeto utiliza uma arquitetura em camadas:

Cliente → Controller → Service → Model

O tratamento de exceções é realizado pela camada `exception`, enquanto a documentação é configurada no pacote `config`.

## Execução do projeto

Abra o projeto no IntelliJ IDEA e execute a classe `GerenciadorTarefasApplication`.

A aplicação ficará disponível em `http://localhost:8080`.

## Observação

Os dados são armazenados temporariamente em memória e são perdidos quando a aplicação é reiniciada.

## Testes realizados

Foram testados os métodos GET, POST, PUT e DELETE, além das validações de campos e respostas de erro, utilizando o Swagger UI.
