# Gerenciador de Tarefas

Projeto desenvolvido para a atividade da faculdade utilizando Java e Spring Boot.

O sistema permite cadastrar, listar, atualizar e excluir tarefas pessoais.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Maven
- Postman

## Arquitetura do projeto

O projeto utiliza uma arquitetura em camadas, separando as responsabilidades  
da seguinte forma:

- Controller: recebe as requisições HTTP e retorna as respostas.
- Service: executa as operações e regras do sistema.
- Model: representa os dados das tarefas.
- Exception: realiza o tratamento global de erros.

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

## Validações e tratamento de erros

O sistema possui validações para impedir o cadastro de tarefas sem título e limitar o tamanho dos campos.

Também possui tratamento de respostas HTTP:

- 200: requisição realizada com sucesso.
- 201: tarefa cadastrada.
- 204: tarefa excluída.
- 400: dados inválidos.
- 404: tarefa não encontrada.
- 500: erro interno do servidor.

## Testes

Todos os métodos foram testados no Postman e estão funcionando corretamente.

O projeto utiliza armazenamento em memória, portanto as tarefas são perdidas quando a aplicação é reiniciada.