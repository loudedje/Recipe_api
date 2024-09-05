# Aplicativo de Receita (Recipe App)

## **Objetivo do Projeto**

Desenvolver um aplicativo para gerenciar e compartilhar receitas culinárias. A aplicação permitirá aos usuários criar, editar, visualizar e buscar receitas.

## **Funcionalidades Iniciais**

- **Cadastro de Receitas** 
- **Busca e Filtragem de Receitas:** Pesquisa por nome, categoria e ingredientes.
- **Gerenciamento de Ingredientes:** Cadastro e edição de ingredientes.
- **Categorias e Tags:** Criação e gerenciamento de categorias e tags.
- **Autenticação de Usuário:** Registro e login de usuários, com a possibilidade de salvar receitas favoritas.

## **Tecnologias Utilizadas**

- Spring Boot
- Spring Security
- Frontend React
- MySql

## **Estrutura do Projeto**

```
src/
└── main/
    ├── java/
    │   └── com/
    │       └── example/
    │           └── recipeapp/
    │               ├── controller/
    │               ├── model/
    │               ├── repository/
    │               ├── service/
    │               └── RecipeAppApplication.java
    └── resources/
        ├── templates/
        │   ├── index.html
        │   ├── recipe.html
        │   ├── search.html
        │   ├── login.html
        │   └── user.html
        ├── application.properties
```
 **Acessar a Aplicação:**
   - Navegue até [http://localhost:8080](http://localhost:8080) para acessar a aplicação.

## **Próximos Passos e Integrações Futuras**

- **Kafka:** Para processamento assíncrono de eventos como notificações.
- **Cloud:** Deploy em plataformas como AWS.
- **Docker:** Containerização da aplicação.
- **Monitoramento e Logging:** Utilização de Spring Boot.
- **Frontend Avançado:** React.

## **Documentação e Links Úteis**

- [Documentação do Projeto no Notion](https://www.notion.so/Aplicativo-de-Receita-Recipe-App-e14bfc75f3184fc480013784d9601d13?showMoveTo=true&saveParent=true)

## **Contribuição**

Contribuições são bem-vindas! Por favor, faça um fork do repositório e envie um pull request.

## **Licença**

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
