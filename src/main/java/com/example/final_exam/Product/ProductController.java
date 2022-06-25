package com.example.final_exam.Product;

import com.example.final_exam.Domain.AddToCartReq;
import com.example.final_exam.Domain.LoadCartRes;
import com.example.final_exam.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.lang.System.out;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/create")
    public String productCreate(Product form){
        try{
            Product product = form;
            productService.productCreate(product);
            return "homePath";
        }
        catch(Exception e){
            return "homePath";
        }
    }

    @PostMapping("/delete")
    public String productDelete(String name){
        try{
            productService.productDelete(name);
            return "homePath";
        }
        catch(Exception e){
            return "homePath";
        }
    }

    @PostMapping("/add")
    public String addToCart(AddToCartReq form){
        try {
            AddToCartReq addToCartReq = form;
            productService.addToCart(addToCartReq);
            return "homePath";
        }
        catch (Exception e){
            return "homePath";
        }
    }

    @GetMapping("/cart")
    public String loadCart(String id, Model model){
        try{
            List<LoadCartRes> loadCartResList = productService.loadCart(id);

            String name;
            String price;

            for(int i = 0; i < loadCartResList.size(); ++i){
                name = loadCartResList.get(i).getName();
                price = loadCartResList.get(i).getPrice();

                model.addAttribute("name" + i, name);
                model.addAttribute("price" + i, price);
            }

            model.addAttribute("cartSize", loadCartResList.size());
            return "MyPage/cart";
        }
        catch (Exception e){
            return "homePath";
        }
    }
}
