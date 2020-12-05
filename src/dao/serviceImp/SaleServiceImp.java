package dao.serviceImp;

import dao.service.SaleService;
import models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class SaleServiceImp implements SaleService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Sale> querySales() {
        String sql = "select * from \"Sale\" ";
        RowMapper<Sale> rowMapper = new BeanPropertyRowMapper<>(Sale.class);
        List<Sale> list = this.jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    @Override
    public List<Sale> querySalesByProductName(String pName) {
        String sql = "select * from \"Sale\" where \"pName\"like  '%'||?||'%' ";
        RowMapper<Sale> rowMapper = new BeanPropertyRowMapper<>(Sale.class);
        List<Sale> list = this.jdbcTemplate.query(sql, rowMapper,pName);
        return list;
    }

    @Override
    public boolean addSale(Sale salepojo) {
        String sql = "insert into \"Sale\"(\"pid\",\"pName\",\"saleCount\",\"prices\",\"uid\",\"uName\",\"date\") values(?,?,?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        try {
            date = sdf.parse(salepojo.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Object[] obj = new Object[]{
                salepojo.getPid(),
                salepojo.getpName(),
                salepojo.getSaleCount(),
                salepojo.getPrices(),
                salepojo.getUid(),
                salepojo.getuName(),
                date
        };
        return this.jdbcTemplate.update(sql, obj) > 0;
    }

    @Override
    public boolean updateSale(Sale salepojo) {
        String sql = "update \"Sale\" set \"pid\"=?,\"pName\"=?,\"saleCount\"=?,\"prices\"=?,\"uid\"=?,\"uName\"=?,\"date\"=? where \"sid\" =?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        try {
            date = sdf.parse(salepojo.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Object[] obj = new Object[]{
                salepojo.getPid(),
                salepojo.getpName(),
                salepojo.getSaleCount(),
                salepojo.getPrices(),
                salepojo.getUid(),
                salepojo.getuName(),
                date,
                salepojo.getSid()
        };
        return this.jdbcTemplate.update(sql, obj) > 0;
    }

    @Override
    public boolean deleteSale(int sid) {
        String sql = "delete from \"Sale\" where \"sid\"=?";
        return this.jdbcTemplate.update(sql, sid) > 0;
    }
}
