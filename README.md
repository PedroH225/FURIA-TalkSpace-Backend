### FURIA TalkSpace Backend
## Descrição
A **FURIA TalkSpace**, é uma plataforma digital de chats voltada para os fãs das equipes da organização FURIA eSports. A plataforma permite que os torcedores se comuniquem entre si sobre as diferentes equipes da FURIA em diversos jogos, por meio de chats com diversos temas.

## Tecnologias
- **Java 21** – Linguagem de programação utilizada no backend.
- **Spring Boot** – Framework para construção de aplicações Java modernas.
- **Spring Web** – Criação de APIs REST.
- **Spring Data JPA** – Acesso e persistência de dados utilizando ORM.
- **Spring Security** – Gerenciamento de autenticação e segurança da aplicação.
- **Spring WebSocket** – Suporte à comunicação bidirecional em tempo real.
- **JWT (Auth0 Java JWT)** – Autenticação baseada em tokens JSON Web Tokens.
- **MySQL** – Banco de dados relacional.
- **Lombok** – Redução de boilerplate em classes Java (getters, setters, construtores etc.).
- **Docker Compose** – Orquestração e gerenciamento de contêineres para ambientes de desenvolvimento.

## Como instalar e executar o backend

### Pré-requisitos
- **Docker** instalado
- **Java 21** instalado (caso deseje rodar localmente sem Docker)
- **Maven** instalado
- **MySQL** rodando via Docker (não é necessário rodar localmente se usar Docker)

### Execução
1. Clone o repositório e acesse a pasta do backend
```bash
git clone git@github.com:PedroH225/FURIA-TalkSpace-Backend.git
cd FURIA-TalkSpace-Backend/
```

2. No mesmo terminal, execute:
```bash
docker-compose up --build 
```

## Uso
- [Execute o Frontend](https://github.com/PedroH225/FURIA-TalkSpace-Frontend)
- Faça requisições via Postman
