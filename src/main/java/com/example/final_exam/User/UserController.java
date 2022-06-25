package com.example.final_exam.User;

import com.example.final_exam.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static java.lang.System.out;

@Controller
@RequestMapping("/user")
public class UserController { //폼 태그를 이용한 방식이 GET 과 POST메소드만 지원을 하기 때문에 일단 전부 GET/POST으로 매핑했습니다
                              //다른 메소드를 이용할 방법을 찾으면 각자 맞는 메소드로 다시 매핑할 예정입니다.

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(CreateUserReq form){
        try {
            CreateUserReq createUserReq = form;

            if(createUserReq.getId().length() > 45 ||
                    createUserReq.getEmail().length() > 45 ||
                    createUserReq.getPassword().length() > 45 ||
                    createUserReq.getFirstName().length() > 45 ||
                    createUserReq.getLastName().length() > 45) {
                return "CreateUser/CreateError";
            }

            userService.createUser(createUserReq);
            return "CreateUser/CreateSuccess";
        }
        catch (Exception e){
            return "CreateUser/CreateError";
        }
    }

    @PostMapping("/login")
    public String login(LoginReq form){
        try {
            LoginReq loginReq = form;
            userService.login(loginReq);

            LoginRes loginRes = new LoginRes();
            loginRes.setId(loginReq.getId());
            loginRes.setPassword(loginReq.getPassword());

            int isAdmin = userService.checkAdmin(loginReq.getId());
            if(isAdmin == 1){
                return "login/loginSuccessAdmin";
            }
            else{
                return "login/loginSuccess";
            }
        }
        catch (Exception e){
            return "login/loginFailed";
        }
    }

    @GetMapping("/list")
    public String list(Model model){
        try{
            List<User> userList = userService.list();

            User user = new User();


            for(int i = 0; i < userList.size(); ++i){
                user = userList.get(i);

                model.addAttribute("userIdx" + i, user.getUserIdx());
                model.addAttribute("id" + i, user.getId());
                model.addAttribute("email" + i, user.getEmail());
                model.addAttribute("firstName" + i, user.getFirstName());
                model.addAttribute("lastName" + i, user.getLastName());

            }

            model.addAttribute("userSize", userList.size());
            return "UserList/userList";
        }
        catch (Exception e){
            return "UserList/userListError";
        }
    }

    @GetMapping("/deleted")
    public String deletedUserlist(Model model){
        try{
            List<User> userList = userService.deletedUserlist();

            User user = new User();

            for(int i = 0; i < userList.size(); ++i){
                user = userList.get(i);

                model.addAttribute("userIdx" + i, user.getUserIdx());
                model.addAttribute("id" + i, user.getId());
                model.addAttribute("email" + i, user.getEmail());
                model.addAttribute("firstName" + i, user.getFirstName());
                model.addAttribute("lastName" + i, user.getLastName());

            }

            model.addAttribute("userSize", userList.size());
            return "UserList/deletedUserList";
        }
        catch (Exception e){
            return "UserList/userListError";
        }
    }

    @PostMapping("/mercy")
    public String resurrectUser(String id){
        try{
            userService.resurrectUser(id);

            return "homePath";
        }
        catch (Exception e){
            return "homePath";
        }
    }

    @GetMapping("/deleteForm")
    public String moveToDelteForm(Model model){
        try{
            List<User> userList = userService.list();

            User user = new User();


            for(int i = 0; i < userList.size(); ++i){
                user = userList.get(i);

                model.addAttribute("userIdx" + i, user.getUserIdx());
                model.addAttribute("id" + i, user.getId());
                model.addAttribute("email" + i, user.getEmail());
                model.addAttribute("firstName" + i, user.getFirstName());
                model.addAttribute("lastName" + i, user.getLastName());

            }

            model.addAttribute("userSize", userList.size());
            return "DeleteUser/deleteUser";
        }
        catch (Exception e){
            return "homePath";
        }
    }

    @PostMapping("/delete")
    public String deleteUser(String id){
        try{
            userService.deleteUser(id);

            return "homePath"; //
        }
        catch (Exception e){
            return "homePath"; //
        }
    }

    @PostMapping("/admin")
    public String makeHimAdmin(String id){
        try{
            userService.makeHimAdmin(id);
            return "homePath";
        }
        catch (Exception e){
            return "homePath";
        }
    }


    @PostMapping("/modify")
    public String modifyUser(ModifyUserReq form){
        try{
            ModifyUserReq modifyUserReq = form;
            userService.modifyUser(modifyUserReq);
            return "homePath";
        }
        catch (Exception e){
            return "homePath";
        }
    }




}
