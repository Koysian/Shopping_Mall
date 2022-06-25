package com.example.final_exam.Product;

import com.example.final_exam.Domain.AddToCartReq;
import com.example.final_exam.Domain.LoadCartRes;
import com.example.final_exam.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao){
        this.productDao = productDao;
    }

    public void productCreate(Product product) throws Exception{
        try{
            productDao.productCreate(product);
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public void productDelete(String name) throws Exception{
        try {
            productDao.productDelete(name);
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public void addToCart(AddToCartReq addToCartReq) throws Exception{
        try{
            productDao.addToCart(addToCartReq);
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public List<LoadCartRes> loadCart(String id) throws Exception{
        try{
            return productDao.loadCart(id);

        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
