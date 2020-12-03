package Controller;

import models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public boolean Login(@ModelAttribute User user) {
        String name = user.getUserName();
        String password = user.getPassWord();
        System.out.println(name+password);
        return name.equals("admin") && password.equals("123");
    }
}
