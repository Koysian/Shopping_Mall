package com.example.final_exam.Product;

import com.example.final_exam.Domain.AddToCartReq;
import com.example.final_exam.Domain.LoadCartRes;
import com.example.final_exam.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void productCreate(Product product) {
        String createProductQuery = "insert into products (name, price, imgUrl) values(?, ?, ?);";

        Object[] createProductParams = new Object[]{product.getName(), product.getPrice(), product.getImgUrl()};

        this.jdbcTemplate.update(createProductQuery, createProductParams);
    }

    public void productDelete(String name) {
        int productIdx = getProductIdxByName(name);
        if(productIdx == -1){
            return;
        }
        String deleteProductQuery = "delete from cart where productIdx=?;";
        this.jdbcTemplate.update(deleteProductQuery, productIdx);
        deleteProductQuery = "delete from products where productIdx=?;";
        this.jdbcTemplate.update(deleteProductQuery, productIdx);

    }


    public void addToCart(AddToCartReq addToCartReq) {
        int userIdx = getUserIdxById(addToCartReq.getId());
        int productIdx = getProductIdxByName(addToCartReq.getName());
        if(userIdx == -1){
            return;
        }

        Object[] addToCartParams = new Object[]{userIdx, productIdx};

        this.jdbcTemplate.update("insert into cart (userIdx, productIdx) values(?, ?);", addToCartParams);
    }

    public int getProductIdxByName(String name){
        if(this.jdbcTemplate.queryForObject("select exists(select productIdx from products where name=?);", int.class, name) != 1){
            return -1;
        }
        return this.jdbcTemplate.queryForObject("select productIdx from products where name=?", int.class, name);
    }
    public int getUserIdxById(String id){
        if(this.jdbcTemplate.queryForObject("select exists(select userIdx from users where id=?);", int.class, id) != 1){
            return -1;
        }
        return this.jdbcTemplate.queryForObject("select userIdx from users where id=?", int.class, id);
    }

    public List<LoadCartRes> loadCart(String id) {
        int userIdx = getUserIdxById(id);
        String loadCartQuery = "select name, price from products as p\n" +
                "    left join cart as c on c.productIdx = p.productIdx\n" +
                "    where c.userIdx=?;";
        return this.jdbcTemplate.query(loadCartQuery, (rs, rowNum)->new LoadCartRes(rs.getString("name"),
                                                                                    rs.getString("price")),
                                                                                    userIdx);
    }
}
