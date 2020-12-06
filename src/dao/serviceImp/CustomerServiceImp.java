package dao.serviceImp;

import dao.service.CustomerService;
import models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceImp implements CustomerService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> queryCustomers() {
        String sql = "select * from \"Customer\" ";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Customer> queryCustomersByName(String name) {
        String sql = "select * from \"Customer\" where \"name\" like  '%'||?||'%'";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return this.jdbcTemplate.query(sql, rowMapper, name);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        String sql = "insert into \"Customer\" (\"name\",\"phone\",\"notes\") values(?,?,?)";
        Object[] obj = new Object[]{
                customer.getName(),
                customer.getPhone(),
                customer.getNotes()
        };
        return this.jdbcTemplate.update(sql, obj) > 0;
    }

    @Override
    public boolean deleteCustomer(int id) {
        String sql = "delete from\"Customer\" where \"cid\" = ?";
        return this.jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        String sql = "update \"Customer\" set \"name\"=?,\"phone\"=?,\"notes\"=? where \"cid\"=?";
        Object[] obj = new Object[]{
                customer.getName(),
                customer.getPhone(),
                customer.getNotes(),
                customer.getCid()
        };
        return this.jdbcTemplate.update(sql, obj) > 0;
    }

    @Override
    public List<Customer> queryPage(int beginPage, int preSize) {
        String sql = "SELECT * FROM \"Customer\" WHERE ROWNUM<? minus SELECT * FROM \"Customer\" WHERE ROWNUM<?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return this.jdbcTemplate.query(sql, rowMapper, beginPage * preSize + 1, (beginPage - 1) * preSize+1);
    }

    @Override
    public int queryAllCount() {
        String sql = "select count(*) from \"Customer\"";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
