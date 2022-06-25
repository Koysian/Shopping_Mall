package com.example.final_exam.Post;

import com.example.final_exam.Domain.CreatePostReq;
import com.example.final_exam.Domain.DeletePostReq;
import com.example.final_exam.Domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostDao postDao;

    @Autowired
    public PostService(PostDao postDao){
        this.postDao = postDao;
    }

    public List<Post> loadPosts() throws Exception{
        try{
            List<Post> postList = postDao.loadPosts();
            return postList;
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public void createPost(CreatePostReq createPostReq) throws Exception{
        try {
            postDao.createPost(createPostReq);
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public void deletePost(DeletePostReq deletePostReq) throws Exception{
        try {
            postDao.deletePost(deletePostReq);
        }
        catch (Exception e){
            throw new Exception();
        }
    }


}
