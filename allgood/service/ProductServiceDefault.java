package service;
import java.util.ArrayList;
import model.Product;
import dao.ProductDao;

public class ProductServiceDefault implements ProductService {

    private final ProductDao productDao;
    public ProductServiceDefault(ProductDao productDao) {
        this.productDao = productDao;
    }
    @Override
    public void addProduct(String name, long price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama Produk tidak boleh kosong"
            );
        }
        if (price <= 0) {
            throw new IllegalArgumentException(
                "Harga harus angka positif lebih dari 0"
            );
        }
        productDao.save(new Product(0, name, price));
    }
    @Override
    public ArrayList<Product> getAllProducts() {
        return productDao.findAll();
    }
}
