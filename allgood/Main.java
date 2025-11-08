import java.util.Scanner;

import controller.ProductController;
import dao.ProductDao;
import dao.memory.ProductDaoInMemory;
import service.ProductService;
import service.ProductServiceDefault;
import view.ProductConsoleView;

public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoInMemory();
        ProductService productService = new ProductServiceDefault(productDao);
        Scanner scanner = new Scanner(System.in);
        ProductConsoleView productView = new ProductConsoleView(scanner);
        ProductController productController = new ProductController(productService, productView);

        while (true) {
            productView.displayMenu();
            String pilihanMenu = productView.getPilihanMenuFromUser();
            productController.handlingPilihanMenu(pilihanMenu);
        }
    }
}

