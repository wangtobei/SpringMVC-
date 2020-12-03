package utils;

import models.Product;
import models.Purchase;
import models.Supplier;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseMapper implements RowMapper<Purchase> {
    @Override
    public Purchase mapRow(ResultSet resultSet, int i) throws SQLException {
        //supplier
        Supplier supplier = new Supplier();
        supplier.setSupID(resultSet.getInt("supID"));
        supplier.setSupName(resultSet.getString("supName"));
        supplier.setSupContact(resultSet.getString("supContact"));
        supplier.setSupPhone(resultSet.getString("supPhone"));
        supplier.setAddress(resultSet.getString("address"));
        System.out.println(supplier.toString());
        //product
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getFloat("price"));
        product.setStockNum(resultSet.getInt("stockNum"));
        product.setStockNum(resultSet.getInt("salarmNum"));
        product.setId(resultSet.getInt("supId"));
        //purchase
        Purchase purchase = new Purchase();
        purchase.setPcID(resultSet.getInt("pcID"));
        purchase.setCount(resultSet.getInt("count"));
        purchase.setDate(resultSet.getDate("date"));
        purchase.setProduct(product);
        purchase.setSupplier(supplier);
        System.out.println(product);
        return purchase;
    }
}
