package Controller;

import dao.serviceImp.UserServiceImp;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class LoginController {
    private UserServiceImp userServiceImp;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public boolean Login(@ModelAttribute User user) {
        String name = user.getUserName();
        String password = user.getPassWord();
       try {
           List<User> users = this.userServiceImp.queryUser(name);
           return password.equals(users.get(0).getPassWord());
       }catch (Exception e){
           return false;
       }
    }
}
