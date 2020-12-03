package dao.serviceImp;

import dao.service.ProductService;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pojo.ProductBindSupplier;

import java.util.List;


@Component
public class ProductServiceImp implements ProductService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean addProduct(Product product) {
        String sql = "insert into \"Product\" (\"name\",\"price\",\"stockNum\",\"salarmNum\",\"supId\") values(?,?,?,?,?)";
        Object[] obj = new Object[]{
                product.getName(),
                product.getPrice(),
                product.getStockNum(),
                product.getSalarmNum(),
                product.getSupId(),
        };
        int result = this.jdbcTemplate.update(sql, obj);
        return result > 0;
    }

    @Override
    public boolean deleteProduct(Integer id) {
        String sql = "delete from \"Product\" where \"id\"=?";
        int result = this.jdbcTemplate.update(sql, id);
        return result > 0;
    }

    @Override
    public boolean updateProduct(Product product) {
        String sql="update \"Product\" set \"name\"=?,\"price\"=?,\"stockNum\"=?,\"salarmNum\"=?,\"supId\"=? where \"id\" = ? ";
        Object[] obj = new Object[]{
                product.getName(),
                product.getPrice(),
                product.getStockNum(),
                product.getSalarmNum(),
                product.getSupId(),
                product.getId(),
        };
        int result = this.jdbcTemplate.update(sql, obj);
        return result > 0;
    }

    @Override
    public List<ProductBindSupplier> queryProduct(String name) {
        String sql;
        if (name!="" ||name!=null)
        {
            sql ="select * from \"Product\",\"Supplier\" where \"name\" like  '%'||?||'%' and  \"supID\"=\"supId\"";
            RowMapper<ProductBindSupplier> rowMapper = new BeanPropertyRowMapper<>(ProductBindSupplier.class);
            List<ProductBindSupplier> list = this.jdbcTemplate.query(sql, rowMapper,name);
            return list;
        }
        return null;
    }

    @Override
    public List<ProductBindSupplier> queryAllProducts() {
        String sql = "select * from \"Product\",\"Supplier\" where \"supID\"=\"supId\" ";
        RowMapper<ProductBindSupplier> rowMapper = new BeanPropertyRowMapper<>(ProductBindSupplier.class);
        List<ProductBindSupplier> list = this.jdbcTemplate.query(sql, rowMapper);
        return list;
    }
}
