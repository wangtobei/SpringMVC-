package dao.service;

import models.Product;
import pojo.ProductBindSupplier;

import java.util.List;

public interface ProductService {
    public boolean addProduct(Product product);
    public boolean deleteProduct(Integer id);
    public boolean updateProduct(Product product);
    public List<ProductBindSupplier> queryProduct(String name);
    public List<ProductBindSupplier> queryAllProducts();
}
