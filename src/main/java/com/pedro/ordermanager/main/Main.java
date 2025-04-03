package com.pedro.ordermanager.main;

import com.pedro.ordermanager.model.Category;
import com.pedro.ordermanager.model.CustomerOrder;
import com.pedro.ordermanager.model.Product;
import com.pedro.ordermanager.repository.CategoryRepository;
import com.pedro.ordermanager.repository.CustomerOrderRepository;
import com.pedro.ordermanager.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final CategoryRepository repositoryCategory;
    private final CustomerOrderRepository repositoryCustomerOrder;
    private final ProductRepository repositoryProduct;
    private Scanner scanner = new Scanner(System.in);

    public Main(CategoryRepository repositoryCategory, CustomerOrderRepository repositoryCustomerOrder, ProductRepository repositoryProduct) {
        this.repositoryCategory = repositoryCategory;
        this.repositoryCustomerOrder = repositoryCustomerOrder;
        this.repositoryProduct = repositoryProduct;
    }

    public void run() {
        while (true) {

            int choose = showMenu();;

            switch (choose) {
                case 1:
                    createCategory();
                    break;
                case 2:
                    createProduct();
                    break;
                case 3:
                    createOrder();
                    break;
                case 4:
                    findAllCategory();
                    break;
                case 5:
                    findAllProducts();
                    break;
                case 6:
                    findAllOrders();
                    break;
                case 7:
                    listProductForName();
                    break;
                case 8:
                    quitSystem();
                default:
                    System.out.println("Invalid choose!!");
            }
        }
    }

    private int showMenu() {
        System.out.println("""
                    \n1- Create category
                    2- Create product
                    3- Create order
                    4- List categories
                    5- List products
                    6- List orders
                    7- List product for name
                    8- Go out
                    """);
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    private void quitSystem() {
        System.out.println("Going out!");
        scanner.close();
        return;
    }

    private void listProductForName() {
        System.out.println("Enter a part of product name to search: ");
        String partName = scanner.nextLine();
        Optional<List<Product>> listProducts = repositoryProduct.findByPartOfTheName(partName);

        listProducts.ifPresent(listproducts ->
                listproducts.forEach(p -> System.out.println(p.getId() + "° Product: " + p.getName() + " - R$" + p.getPrice() + " | Own category: " + p.getCategory().getName())));
    }

    private void findAllOrders() {
        repositoryCustomerOrder.findAll().forEach(o -> {
            System.out.println(o.getId() + "° Order: " + o.getData() + " | n° products: " + o.getProductsSize());

            o.getProducts().forEach(p -> System.out.println("   " + p.getId() + "° Product: " + p.getName() + " - R$" + p.getPrice() + " | Own category: " + (p.getCategory() != null ? p.getCategory().getName() : "No category")));
        });
    }

    private void findAllProducts() {
        repositoryProduct.findAll().forEach(p -> System.out.println(p.getId() + "° Product: " + p.getName() + " - R$" + p.getPrice() + " | Own category: " + p.getCategory().getName()));
    }

    private void findAllCategory() {
        repositoryCategory.findAll().forEach(c -> System.out.println(c.getId() + "° Category: " + c.getName() + " | n° products: " + c.getProductsSize()));
    }

    private void createOrder() {
        repositoryProduct.findAll().forEach(p -> System.out.println(p.getId() + "° Product: " + p.getName() + " - R$" + p.getPrice() + " | Own category: " + p.getCategory().getName()));
        System.out.println("Enter the product name, enter with 0 to out: ");
        var listOrders = new ArrayList<Product>();

        String productName;
        do {
            productName = scanner.nextLine();
            if (!productName.equals("0")) {
                Optional<Product> optionalProduct = repositoryProduct.findByNameContainingIgnoreCase(productName);
                if (optionalProduct.isPresent()) {
                    optionalProduct.ifPresent(listOrders::add);
                    System.out.println("Product add successfully!");
                } else {
                    System.out.println("Product not found.");
                }
            }
        } while (!productName.equals("0"));
        CustomerOrder order = new CustomerOrder();
        order.setProducts(listOrders);

        repositoryCustomerOrder.save(order);
    }

    private void createProduct() {
        String nome;
        double price;
        //Product category = new Category(scanner.nextLine());
        System.out.print("Informe o nome do produto: ");
        nome = scanner.nextLine();
        System.out.print("Informe o preco do produto: ");
        price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Choose an category: ");
        repositoryCategory.findAll().forEach(c -> System.out.println(c.getId() + "° Category: " + c.getName()));
        List<Category> categories = repositoryCategory.findAll();
        int chooseCategory = scanner.nextInt();
        scanner.nextLine();
        repositoryProduct.save(new Product(nome, price, categories.get(chooseCategory - 1)));
    }

    private void createCategory() {
        Category category = new Category(scanner.nextLine());
        repositoryCategory.save(category);
    }
}


