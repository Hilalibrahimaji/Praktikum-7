package service;
import java.util.ArrayList;
import model.Product;
public class ProductServiceDefault implements ProductService {
    private final ArrayList<Product> productList = new ArrayList<>();

    public ProductServiceDefault() {
        productList.add(new Product(1, "Laptop", 95000000));
        productList.add(new Product(2, "Smartphone", 25000000));
    }
    @Override
    public void addProduct(String name, long price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Harga harus angka positif lebih dari 0");
        }
        int newId = productList.size() + 1;
        productList.add(new Product(newId, name, price));
    }
    @Override
    public ArrayList<Product> getAllProducts() {
        return productList;
    }
}