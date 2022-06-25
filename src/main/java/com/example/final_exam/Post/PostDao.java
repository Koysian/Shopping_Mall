package com.example.final_exam.Post;

import com.example.final_exam.Domain.CreatePostReq;
import com.example.final_exam.Domain.DeletePostReq;
import com.example.final_exam.Domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PostDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Post> loadPosts() {
        String loadPostsQuery = "select postIdx, title, content, id\n" +
                "FROM posts as p\n" +
                "    left join users as u on u.userIdx = p.userIdx;";
        return this.jdbcTemplate.query(loadPostsQuery, (rs, rowNum) -> new Post(rs.getInt("postIdx"), rs.getString("title"),
                rs.getString("content"), rs.getString("id")));
    }

    public void createPost(CreatePostReq createPostReq) {
        String createPostQuery = "insert into posts (title, content, userIdx) values(?, ?, ?);";
        int userIdx = getUserIdxById(createPostReq.getId());
        Object[] createPostParams = new Object[]{createPostReq.getTitle(), createPostReq.getContent(), (int)userIdx};

        this.jdbcTemplate.update(createPostQuery, createPostParams);
    }

    public int getUserIdxById(String id){
        if(this.jdbcTemplate.queryForObject("select exists(select userIdx from users where id=?);", int.class, id) != 1){
            return -1;
        }
        return this.jdbcTemplate.queryForObject("select userIdx from users where id=?", int.class, id);
    }

    public void deletePost(DeletePostReq deletePostReq) throws Exception{

        int userIdx = getUserIdxById(deletePostReq.getId());
        Object[] deletePostParams = new Object[]{deletePostReq.getTitle(), userIdx, deletePostReq.getPostIdx()};
        if(this.jdbcTemplate.queryForObject("select exists(select title from posts where title = ? and userIdx = ? and postIdx = ?);", int.class, deletePostParams) != 1){
            throw new Exception();
        }
        String deletePostQuery = "delete from posts as p where title = ? and userIdx = ? and postIdx = ?;";


        this.jdbcTemplate.update(deletePostQuery, deletePostParams);
    }
}
