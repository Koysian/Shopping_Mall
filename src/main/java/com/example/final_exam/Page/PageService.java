package com.example.final_exam.Page;

import com.example.final_exam.Domain.Post;
import com.example.final_exam.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {
    private final PageDao pageDao;

    @Autowired
    public PageService(PageDao pageDao){
        this.pageDao = pageDao;
    }

    public List<Product> loadProducts() throws Exception{
        try{
            List<Product> productList = pageDao.loadProducts();
            return productList;
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
