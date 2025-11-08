package dao.memory;

import dao.ProductDao;
import java.util.ArrayList;
import model.Product;

public class ProductDaoInMemory implements ProductDao {
    private final ArrayList<Product> storage = new ArrayList<>();
    private int nextId = 1;

    public ProductDaoInMemory() {
        storage.add(new Product(1, "Laptop", 95000000));
        storage.add(new Product(2, "Smartphone", 25000000));
        nextId = 3;
    }
    @Override
    public void save(Product product) {
        if (product.getId() == 0) {
            product.setId(nextId++);
        }
        storage.add(product);
    }
    @Override
    public ArrayList<Product> findAll() {
        return storage;
    }
}
