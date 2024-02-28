package com.vann;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Long id, String name, Double price, Integer quantity, Category category) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setName(name);
                product.setPrice(price);
                product.setQuantity(quantity);
                product.setCategory(category);
                break;
            }
        }
    }

    public void deleteProduct(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.remove(i);
                break; // Sau khi xóa phần tử, cần break để thoát khỏi vòng lặp
            }
        }
    }


    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return this.products;
    }

    public List<Product> getProductsByCategory(Category category) {
        List<Product> categoryProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    public List<Product> getProductsPriceGreaterThan(double price) {
        List<Product> selectedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() > price) {
                selectedProducts.add(product);
            }
        }
        return selectedProducts;
    }

    public List<Product> getExpensiveElectronics() {
        List<Product> expensiveElectronics = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() > 200000 && product.getCategory().getName().equals("Điện tử")) {
                expensiveElectronics.add(product);
            }
        }
        return expensiveElectronics;
    }
}
