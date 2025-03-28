package com.pedro.ordermanager.main;

import com.pedro.ordermanager.model.Category;
import com.pedro.ordermanager.model.CustomerOrder;
import com.pedro.ordermanager.model.Product;
import com.pedro.ordermanager.repository.CategoryRepository;
import com.pedro.ordermanager.repository.CustomerOrderRepository;
import com.pedro.ordermanager.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);

    public void run(CategoryRepository repoCategory, CustomerOrderRepository repoCustomerOrder, ProductRepository repoProduct) {
        while (true) {
            System.out.println("""
                    \n1- Create category
                    2- Create product
                    3- Create order
                    4- List categories
                    5- List products
                    6- List orders
                    7- Go out
                    """);
            System.out.print("Choose an option: ");
            int choose = scanner.nextInt();
            scanner.nextLine();

            String nome;
            double price;
            switch (choose) {
                case 1:
                    Category category = new Category(scanner.nextLine());
                    repoCategory.save(category);
                    break;
                case 2:
                    //Product category = new Category(scanner.nextLine());
                    System.out.print("Informe o nome do produto: ");
                    nome = scanner.nextLine();
                    System.out.print("Informe o preco do produto: ");
                    price = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Choose an category: ");
                    repoCategory.findAll().forEach(c -> System.out.println(c.getId() + "° Category: " + c.getName()));
                    List<Category> categories = repoCategory.findAll();
                    int chooseCategory = scanner.nextInt();
                    scanner.nextLine();
                    repoProduct.save(new Product(nome, price, categories.get(chooseCategory - 1)));
                    break;
                case 3:
                    System.out.println("Enter the product name: ");
                    String productName = scanner.nextLine();

                    var product = repoProduct.findByName(productName);

                    if (product != null) {
                        CustomerOrder order = new CustomerOrder();
                        order.addProduct(product);

                        //product.setOrders(order); // Garante a relação bidirecional
                        //product.getOrders().forEach(System.out::println);
                        //repoProduct.save(product); // Salva a atualização do relacionamento no banco
                        repoCustomerOrder.save(order);

                        System.out.println("Order created successfully!");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    repoCategory.findAll().forEach(c -> System.out.println(c.getId() + "° Category: " + c.getName() + " | n° products: " + c.getProductsSize()));
                    break;
                case 5:
                    repoProduct.findAll().forEach(p -> System.out.println(p.getId() + "° Product: " + p.getName() + " - R$" + p.getPrice() + " | Own category: " + p.getCategory().getName()));
                    break;
                case 6:
                    repoCustomerOrder.findAll().forEach(o -> {
                        System.out.println(o.getId() + "° Order: " + o.getData() + " | n° products: " + o.getProductsSize());

                        o.getProducts().forEach(p ->
                                System.out.println("   " + p.getId() + "° Product: " + p.getName() + " - R$" + p.getPrice() +
                                        " | Own category: " + (p.getCategory() != null ? p.getCategory().getName() : "No category"))
                        );
                    });

                    break;
                case 7:
                    System.out.println("Going out!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choose!!");
            }
        }
    }
}
//        var category = repoCategory.findByName("Pet");
//        System.out.println(category.getName());
//        // Criação dos produtos
//        Product product = new Product("Computer", 5000.0, category);
//        //repoProduct.save(product);
/// /        Product product2 = new Product("PlacaDeVideo", 15000.0, category2);
/// /
/// /        // Criando o pedido e associando os produtos
//        CustomerOrder order = new CustomerOrder();
//        order.addProduct(product);
/// /        order.addProduct(product2);
//        repoCustomerOrder.save(order);

//        // Salvar o pedido com os produtos associados
//        product.getOrders().add(order);
//        product2.getOrders().add(order);
//        repoProduct.save(product);
//        repoProduct.save(product2);
//

