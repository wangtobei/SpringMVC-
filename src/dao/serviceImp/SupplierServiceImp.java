package dao.serviceImp;

import dao.service.SupplierService;
import models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Component
public class SupplierServiceImp implements SupplierService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Supplier> querySuppliers() {
        String sql = "select * from \"Supplier\" order by \"supID\"";
        RowMapper<Supplier> rowMapper = new BeanPropertyRowMapper<Supplier>(Supplier.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Supplier> querySupper(String supName) {
        String sql = "select * from \"Supplier\" where \"supName\" like  '%'||?||'%' order by \"supID\"";
        RowMapper<Supplier> rowMapper = new BeanPropertyRowMapper<Supplier>(Supplier.class);
        return this.jdbcTemplate.query(sql, rowMapper, supName);
    }

    @Override
    public boolean addSupper(Supplier supplier) {
        String sql = "insert into \"Supplier\" (\"supName\",\"supContact\",\"supPhone\",\"address\") values(?,?,?,?)";
        Object[] obj = new Object[]{
                supplier.getSupName(),
                supplier.getSupContact(),
                supplier.getSupPhone(),
                supplier.getAddress()
        };
        return this.jdbcTemplate.update(sql, obj) > 0;
    }

    @Override
    public boolean updateSupper(Supplier supplier) {
        String sql = "update \"Supplier\" set \"supName\"=?,\"supContact\"=?,\"supPhone\"=?,\"address\"=? where \"supID\"=?";
        Object[] obj = new Object[]{
                supplier.getSupName(),
                supplier.getSupContact(),
                supplier.getSupPhone(),
                supplier.getAddress(),
                supplier.getSupID()
        };
        return this.jdbcTemplate.update(sql, obj) > 0;
    }

    @Override
    public boolean deleteSupper(int supID) {
        String sql = "delete from \"Supplier\" where \"supID\"=?";
        return this.jdbcTemplate.update(sql, supID) > 0;
    }
}
