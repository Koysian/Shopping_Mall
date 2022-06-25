package com.example.final_exam.Page;

import com.example.final_exam.Domain.Post;
import com.example.final_exam.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PageDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Product> loadProducts() {
        String loadPostsQuery = "select name, price, imgUrl from products";
        return this.jdbcTemplate.query(loadPostsQuery, (rs, rowNum) -> new Product(rs.getString("name"), rs.getString("price"),
                rs.getString("imgUrl")));
    }
}
