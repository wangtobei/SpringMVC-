package Controller;

import dao.serviceImp.UserServiceImp;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserServiceImp userServiceImp;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @ResponseBody
    @RequestMapping("/query")
    public List<User> queryUser(@RequestParam(value = "username") String username) {
        return userServiceImp.queryUser(username);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public boolean deleteUser(@RequestParam(value = "uid") Integer id) {
        return userServiceImp.deleteUser(id);
    }

    @ResponseBody
    @RequestMapping("/add")
    public boolean addUser(User user) {
        return userServiceImp.addUser(user);
    }

    @ResponseBody
    @RequestMapping("/update")
    public boolean update(User user) {
        return userServiceImp.updateUser(user);
    }

    @ResponseBody
    @RequestMapping("/all")
    public List<User> queryUsers() {
        return this.userServiceImp.queryUsers();
    }
}
