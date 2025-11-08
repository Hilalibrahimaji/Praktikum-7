package service;
import java.util.ArrayList;
import model.Product;
public interface ProductService {
    void addProduct(String name, long price);
    ArrayList<Product> getAllProducts();
}