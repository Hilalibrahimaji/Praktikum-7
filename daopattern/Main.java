import java.util.ArrayList;
import java.util.Scanner;

import dao.ProductDao;
import dao.memory.ProductDaoInMemory;
import model.Product;

public class Main {
    private final ProductDao productDao = new ProductDaoInMemory();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.startMenuLoop();
        app.scanner.close();
    }
    public void startMenuLoop(){
        boolean running = true;
        while (running) {
            System.out.println("\n=== APLIKASI DAO PATTERN ===");
            System.out.println("1. Tampilkan Semua Produk");
            System.out.println("2. Tambah Produk Baru");
            System.out.println("3. Keluar");
            System.out.println("Pilih Opsi: ");
            try{
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayAllProducts();
                        break;
                    case 2:
                        addNewProduct();
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("Opsi tidak valid. Silakan coba lagi.");
                }
            }catch (Exception e){
                System.out.println("Input error: " + e.getMessage());
            }
        }
    }
    private void displayAllProducts() {
        System.out.println("\n--- Daftar Produk ---");
        ArrayList<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }
    private void addNewProduct() {
        System.out.print("Nama Produk: ");
        String name = scanner.nextLine();
        System.out.print("Harga Produk: ");
        long price = Long.parseLong(scanner.nextLine());
        if (price <= 0) {
            System.out.println("Error: Harga Harus angka positif lebih dari 0.");
            return;
        }
        int newId = productDao.findAll().size() + 1;
        Product newProduct = new Product(newId, name, price);
        productDao.save(newProduct);
        System.out.println("Produk berhasil ditambahkan.");
    }
}
