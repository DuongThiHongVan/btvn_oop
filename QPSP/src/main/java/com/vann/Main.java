package com.vann;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void menu() {
        System.out.println("----- MENU -----");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Sửa thông tin sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Hiển thị sản phẩm theo ID");
        System.out.println("5. Hiển thị tất cả sản phẩm");
        System.out.println("6. Hiển thị sản phẩm theo Category");
        System.out.println("7. Tính tổng tiền của các sản phẩm");
        System.out.println("8. Hiển thị các sản phẩm có giá > 100000");
        System.out.println("9. Hiển thị các sản phẩm có giá > 200000 và Category là 'Điện tử'");
        System.out.println("0. Thoát");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();

        // Tạo sẵn 3 đối tượng Category
        Category electronics = new Category("Điện tử");
        Category clothing = new Category("Quần áo");
        Category food = new Category("Thực phẩm");

        // Thêm các Category vào danh sách
        List<Category> categories = new ArrayList<>();
        categories.add(electronics);
        categories.add(clothing);
        categories.add(food);

        // Menu
        while (true) {
            menu();
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự newline

            switch (choice) {
                case 1:
                    // Thêm sản phẩm
                    addProduct(scanner, productManager, categories);
                    break;
                case 2:
                    // Sửa thông tin sản phẩm
                    updateProduct(scanner, productManager, categories);
                    break;
                case 3:
                    // Xóa sản phẩm
                    deleteProduct(scanner, productManager);
                    break;
                case 4:
                    // Hiển thị sản phẩm theo ID
                    displayProductById(scanner, productManager);
                    break;
                case 5:
                    // Hiển thị tất cả sản phẩm
                    displayAllProducts(productManager);
                    break;
                case 6:
                    // Hiển thị sản phẩm theo Category
                    displayProductsByCategory(scanner, productManager, categories);
                    break;
                case 7:
                    // Tính tổng tiền của các sản phẩm
                    displayTotalPrice(productManager);
                    break;
                case 8:
                    // Hiển thị các sản phẩm có giá > 100000
                    displayProductsPriceGreaterThan(scanner, productManager);
                    break;
                case 9:
                    // Hiển thị các sản phẩm có giá > 200000 và Category là 'Điện tử'
                    displayExpensiveElectronics(productManager);
                    break;
                case 0:
                    // Thoát chương trình
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void addProduct(Scanner scanner, ProductManager productManager, List<Category> categories) {
        System.out.print("Nhập ID sản phẩm: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Đọc bỏ ký tự newline
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá tiền: ");
        Double price = scanner.nextDouble();
        System.out.print("Nhập số lượng: ");
        Integer quantity = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ ký tự newline
        System.out.print("Chọn Category (0: Điện tử, 1: Quần áo, 2: Thực phẩm): ");
        int categoryIndex = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ ký tự newline
        if (categoryIndex >= 0 && categoryIndex < categories.size()) {
            Category category = categories.get(categoryIndex);
            Product product = new Product(id, name, price, quantity, category);
            productManager.addProduct(product);
            System.out.println("Sản phẩm đã được thêm vào.");
        } else {
            System.out.println("Lựa chọn Category không hợp lệ.");
        }
    }

    private static void updateProduct(Scanner scanner, ProductManager productManager, List<Category> categories) {
        // Sửa thông tin sản phẩm
        System.out.print("Nhập ID sản phẩm cần sửa: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Đọc bỏ ký tự newline
        Product productToUpdate = productManager.getProductById(id);
        if (productToUpdate != null) {
            System.out.print("Nhập tên mới: ");
            String newName = scanner.nextLine();
            System.out.print("Nhập giá mới: ");
            Double newPrice = scanner.nextDouble();
            System.out.print("Nhập số lượng mới: ");
            Integer newQuantity = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự newline
            System.out.print("Chọn Category mới (0: Điện tử, 1: Quần áo, 2: Thực phẩm): ");
            int categoryIndex = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự newline
            if (categoryIndex >= 0 && categoryIndex < categories.size()) {
                Category newCategory = categories.get(categoryIndex);
                productManager.updateProduct(id, newName, newPrice, newQuantity, newCategory);
                System.out.println("Thông tin sản phẩm đã được cập nhật.");
            } else {
                System.out.println("Lựa chọn Category không hợp lệ.");
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
        }
    }

    private static void deleteProduct(Scanner scanner, ProductManager productManager) {
        // Xóa sản phẩm
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Đọc bỏ ký tự newline
        productManager.deleteProduct(id);
        System.out.println("Sản phẩm đã được xóa.");
    }

    private static void displayProductById(Scanner scanner, ProductManager productManager) {
        // Hiển thị sản phẩm theo ID
        System.out.print("Nhập ID sản phẩm cần hiển thị: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Đọc bỏ ký tự newline
        Product product = productManager.getProductById(id);
        if (product != null) {
            System.out.println("Thông tin sản phẩm:");
            System.out.println("ID: " + product.getId());
            System.out.println("Tên: " + product.getName());
            System.out.println("Giá: " + product.getPrice());
            System.out.println("Số lượng: " + product.getQuantity());
            System.out.println("Category: " + product.getCategory().getName());
        } else {
            System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
        }
    }

    private static void displayAllProducts(ProductManager productManager) {
        // Hiển thị tất cả sản phẩm
        List<Product> allProducts = productManager.getAllProducts();
        if (allProducts.isEmpty()) {
            System.out.println("Không có sản phẩm nào.");
        } else {
            System.out.println("Danh sách sản phẩm:");
            for (Product product : allProducts) {
                System.out.println("ID: " + product.getId() + ", Tên: " + product.getName() + ", Giá: " + product.getPrice() + ", Số lượng: " + product.getQuantity() + ", Category: " + product.getCategory().getName());
            }
        }
    }

    private static void displayProductsByCategory(Scanner scanner, ProductManager productManager, List<Category> categories) {
        // Hiển thị sản phẩm theo Category
        System.out.println("Chọn Category để hiển thị sản phẩm:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(i + ". " + categories.get(i).getName());
        }
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ ký tự newline
        if (choice >= 0 && choice < categories.size()) {
            Category category = categories.get(choice);
            List<Product> productsByCategory = productManager.getProductsByCategory(category);
            if (productsByCategory.isEmpty()) {
                System.out.println("Không có sản phẩm nào thuộc Category này.");
            } else {
                System.out.println("Danh sách sản phẩm thuộc Category " + category.getName() + ":");
                for (Product product : productsByCategory) {
                    System.out.println("ID: " + product.getId() + ", Tên: " + product.getName() + ", Giá: " + product.getPrice() + ", Số lượng: " + product.getQuantity());
                }
            }
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private static void displayTotalPrice(ProductManager productManager) {
        // Tính tổng tiền của các sản phẩm
        double totalPrice = productManager.getTotalPrice();
        System.out.println("Tổng tiền của các sản phẩm: " + totalPrice);
    }

    private static void displayProductsPriceGreaterThan(Scanner scanner, ProductManager productManager) {
        // Hiển thị các sản phẩm có giá > 100000
        List<Product> productsPriceGreaterThan = productManager.getProductsPriceGreaterThan(100000);
        if (productsPriceGreaterThan.isEmpty()) {
            System.out.println("Không có sản phẩm nào có giá trên 100000.");
        } else {
            System.out.println("Danh sách sản phẩm có giá trên 100000:");
            for (Product product : productsPriceGreaterThan) {
                System.out.println("ID: " + product.getId() + ", Tên: " + product.getName() + ", Giá: " + product.getPrice() + ", Số lượng: " + product.getQuantity());
            }
        }
    }

    private static void displayExpensiveElectronics(ProductManager productManager) {
        // Hiển thị các sản phẩm có giá > 200000 và Category là 'Điện tử'
        List<Product> expensiveElectronics = productManager.getExpensiveElectronics();
        if (expensiveElectronics.isEmpty()) {
            System.out.println("Không có sản phẩm Điện tử nào có giá trên 200000.");
        } else {
            System.out.println("Danh sách sản phẩm Điện tử có giá trên 200000:");
            for (Product product : expensiveElectronics) {
                System.out.println("ID: " + product.getId() + ", Tên: " + product.getName() + ", Giá: " + product.getPrice() + ", Số lượng: " + product.getQuantity());
            }
        }
    }
}
