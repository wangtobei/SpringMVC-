package dao.serviceImp;

import dao.service.UserService;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImp implements UserService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> queryUser(String username) {
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        String sql = "select * from \"User\" where \"userName\" = ?";
        try {
            List<User> user = this.jdbcTemplate.query(sql, rowMapper, username);
            return user;
        }catch (Exception e){
        }
        return new ArrayList();
    }

    @Override
    public List<User> queryUsers() {
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        String sql = "select * from \"User\"";
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public boolean deleteUser(int id) {
        String sql = "delete from \"User\" where \"empID\"=?";
        return this.jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update \"User\" set \"userName\"=?,\"passWord\"=?,\"empPost\"=?,\"phone\"=?,\"privilege\"=? where \"empID\"=?";
        Object[] obj = new Object[]{
                user.getUserName(),
                user.getPassWord(),
                user.getEmpPost(),
                user.getPhone(),
                user.getPrivilege(),
                user.getEmpID()
        };
        int row = this.jdbcTemplate.update(sql, obj);
        return row > 0;
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into \"User\" (\"userName\",\"passWord\",\"empPost\",\"phone\",\"privilege\") values(?,?,?,?,?)";
        Object[] obj = new Object[]{
                user.getUserName(),
                user.getPassWord(),
                user.getEmpPost(),
                user.getPhone(),
                user.getPrivilege(),
        };
        int row = this.jdbcTemplate.update(sql, obj);
        return row > 0;
    }
}
