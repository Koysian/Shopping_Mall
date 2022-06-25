package com.example.final_exam.Page;

import com.example.final_exam.Domain.Product;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.lang.System.out;

@Controller
public class PageController {
    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService){
        this.pageService = pageService;
    }

    @GetMapping("/")
    public String goHome(Model model){
        try {
            List<Product> productList = pageService.loadProducts();

            String temp_name;
            String temp_price;
            String temp_imgUrl;
            int temp_postIdx;

            for(int i = 0; i < productList.size(); ++i){
                temp_name = productList.get(i).getName();
                temp_price = productList.get(i).getPrice();
                temp_imgUrl = productList.get(i).getImgUrl();

                model.addAttribute("name" + i, temp_name);
                model.addAttribute("price" + i, temp_price);
                model.addAttribute("imgUrl" + i, temp_imgUrl);
            }

            model.addAttribute("productSize", productList.size());
            return "home";
        }
        catch (Exception e){
            return "homeFailed";
        }
    }

    @GetMapping("/create")
    public String createUser(){return "CreateUser/CreateUser";}

    @GetMapping("/login")
    public String login(){return "login/Login";}

    @GetMapping("/logout")
    public String logout(){return "Logout";}

    @GetMapping("/myPage")
    public String myPage(){return "MyPage/myPage";}

    @GetMapping("/modifyForm")
    public String modifyForm(){return "MyPage/modifyForm";}

    @GetMapping("/admin")
    public String admin(){return "Admin/Admin";}

    @GetMapping("/createAdminForm")
    public String createAdminForm(){return "Admin/CreateAdmin";}

    @GetMapping("/createPostForm")
    public String createPostForm(){return "Post/createPost";}

    @GetMapping("/createProductForm")
    public String createProductForm(){return "Products/createForm";}

    @GetMapping("/deleteProductForm")
    public String deleteProductForm(){return "Products/deleteForm";}

    @GetMapping("/modifyUserForm")
    public String modifyUserForm(){return "MyPage/modifyForm";}

    @GetMapping("/deletePostForm")
    public String deletePostForm(){return "Post/deletePost";}


}
