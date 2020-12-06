package Controller;


import dao.serviceImp.UserServiceImp;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public boolean Login(@ModelAttribute User user, HttpSession httpSession) {
        String name = user.getUserName();
        String password = user.getPassWord();
        try {
            List<User> users = this.userServiceImp.queryUser(name);
            if (password.equals(users.get(0).getPassWord())) {
                httpSession.setAttribute("USER_SESSION", users.get(0));
                System.out.println(httpSession.getAttribute("USER_SESSION"));
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public boolean Logout(HttpSession session) {
        session.invalidate();
        return true;
    }

    @RequestMapping("/check")
    @ResponseBody
    public boolean is_login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if (user != null) {
            System.out.println("login success");
            return true;
        } else {
            System.out.println("not login");
            return false;
        }
    }

    @RequestMapping("/privilege")
    @ResponseBody
    public int Privilege(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if (user != null) {
            return user.getPrivilege();
        } else {
            System.out.println("not login");
            return 0;
        }
    }
}
