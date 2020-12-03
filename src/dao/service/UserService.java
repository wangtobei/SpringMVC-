package dao.service;

import models.User;

import java.util.List;

public interface UserService {
    public User queryUser(String username);
    public List<User> queryUsers();
    public boolean deleteUser(int id);
    public boolean updateUser(User user);
    public boolean addUser(User user);
}
