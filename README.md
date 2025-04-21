Order mananger API


# 📦 OrderManager - Sistema de Gerenciamento de Pedidos e Produtos

O **OrderManager** é um sistema backend desenvolvido em Java com Spring Boot que oferece funcionalidades essenciais para o gerenciamento de pedidos de clientes e produtos. Ele simula a base de um sistema de e-commerce, permitindo registrar pedidos, controlar produtos e acompanhar as informações das compras realizadas.

Este projeto tem como objetivo praticar e aplicar conceitos de APIs RESTful, mapeamento objeto-relacional com JPA/Hibernate, relacionamento entre entidades e uso de DTOs para uma arquitetura limpa.

---

## 🚀 Tecnologias utilizadas

- **Java 17+**
- **Spring Boot**
- **JPA + Hibernate**
- **PostgreSQL**
- **Lombok**
- **DTOs + Bean Validation**
- **Insomnia/Postman** (para testar a API)

---

## 📌 Funcionalidades

✅ Cadastro de pedidos com lista de itens, total e cliente  
✅ CRUD completo de produtos  
✅ Respostas de API com status adequados e tratamento de exceções  
✅ Arquitetura organizada e extensível  

---

## 📡 Endpoints Principais

| Método | Endpoint         | Descrição                      |
|--------|------------------|-------------------------------|
| GET    | `/products`        | Listagem de todos os produtos  |
| POST   | `/products`        | Criação de um novo produtos     |
| GET    | `/customer/{id}`   | Detalhes de um pedido         |
| GET    | `/customer`   | Detalhes de todos os pedidos       |
| POST | `/customer`   | Adicionar de um pedido          |
| PUT    | `/customer/{id}`   | Atualização de um pedido      |
| DELETE    | `/customer/{id}`   | Deletar um pedido      |

---

## 🔧 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/PedroFDias/Order-Mananger.git
   ```
2. Abra o projeto na sua IDE (IntelliJ, VS Code, etc.)
3. Certifique-se de ter:
   - Java 17+ instalado
   - PostgreSQL rodando com banco configurado
4. Configure seu `application.properties` com os dados do banco
5. Execute a aplicação via Spring Boot

---

## 📷 Exemplos de uso

A API pode ser testada via **Postman** ou **Insomnia**.  
Exemplo de resposta ao buscar um pedido:

```json
{
	"id": 17,
	"date": "2025-04-21",
	"totalItems": 5,
	"items": [
		{
			"productId": 4,
			"productName": "Memoria Astralys - 32Gb",
			"quantity": 1,
			"price": 450
		},
		{
			"productId": 12,
			"productName": "Memoria Vercitos - 32Gb",
			"quantity": 4,
			"price": 500
		}
	]
}
```

---

## 🛠 Estrutura do projeto

- `CustomerOrder` → representa um pedido do cliente  
- `Item` → representa o item do pedido, com quantidade e produto  
- `Product` → produto disponível no sistema  
- `OrderController`, `ProductController` → endpoints REST  
- `DTOs` → para entrada e saída de dados  

---

## 📜 Licença

Este projeto é de código aberto e está licenciado sob a **MIT License**.
