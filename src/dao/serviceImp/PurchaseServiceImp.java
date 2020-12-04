package dao.serviceImp;

import dao.service.PurchaseService;
import models.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pojo.Purchasepojo;
import utils.PurchaseMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class PurchaseServiceImp implements PurchaseService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Purchase> queryPurchase() {
        String sql = "select * from \"Purchase\",\"Product\",\"Supplier\" where \"pid\"= \"Product\".\"id\" and \"sid\"=\"supID\"";
        RowMapper<Purchase> rowMapper = new BeanPropertyRowMapper<>(Purchase.class);
        return this.jdbcTemplate.query(sql, new PurchaseMapper());
    }

    @Override
    public boolean addPurchase(Purchasepojo purchase) {
        String sql = "insert into \"Purchase\" (\"pid\",\"sid\",\"count\",\"date\") values(?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(purchase.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Object[] obj = new Object[]{
                purchase.getPid(),
                purchase.getSid(),
                purchase.getCount(),
                date
        };

        return this.jdbcTemplate.update(sql, obj) > 0;
    }

    @Override
    public boolean deletePurchase(int id) {
        String sql = "delete from \"Purchase\" where \"pcID\"=?";
        return this.jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public boolean updatePurchase(Purchasepojo purchase) {
        String sql = "update \"Purchase\" set \"pid\"=?,\"sid\"=?,\"count\"=?,\"date\"=? where \"pcID\" =?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(purchase.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Object[] obj = new Object[]{
                purchase.getPid(),
                purchase.getSid(),
                purchase.getCount(),
                date,
                purchase.getPcID()
        };
        return this.jdbcTemplate.update(sql, obj) > 0;
    }

    @Override
    public List<Purchase> queryPurchaseByName(String name) {
        String sql = "select * from \"Purchase\",\"Product\",\"Supplier\" where \"pid\"= \"Product\".\"id\" and \"sid\"=\"supID\" and \"Product\".\"name\" like  '%'||?||'%'";
        RowMapper<Purchase> rowMapper = new BeanPropertyRowMapper<>(Purchase.class);
        return this.jdbcTemplate.query(sql, new PurchaseMapper(),name);
    }
}
